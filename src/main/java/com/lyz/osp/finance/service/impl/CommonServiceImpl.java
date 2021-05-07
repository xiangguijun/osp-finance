package com.lyz.osp.finance.service.impl;

import com.lyz.osp.finance.entity.XmlResult;
import com.lyz.osp.finance.entity.xml.base.Body;
import com.lyz.osp.finance.entity.xml.base.ErrorResult;
import com.lyz.osp.finance.entity.xml.base.OkResult;
import com.lyz.osp.finance.service.CommonService;
import com.lyz.osp.finance.webservice.WingsoftWebServiceStub;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.io.StringReader;

@Slf4j
@Service
public class CommonServiceImpl implements CommonService {

    @Value("${system.webservice.targetPoint}")
    private String targetPoint;

//    @Autowired
//    private WingsoftWebServiceStub stub;

    @Override
    public XmlResult<Body> submit(String xmlData) {
        String sign = CommonService.buildSign(xmlData);
        return submit(xmlData, sign);
    }

    @Override
    public XmlResult<Body> submit(String xmlData, String sign) {
        return submit(xmlData, sign, Body.class);
    }

    @Override
    public <T extends Body> XmlResult<T> submit(String xmlData, Class<T> clazz) {
        String sign = CommonService.buildSign(xmlData);
        return submit(xmlData, sign, clazz);
    }

    @Override
    public <T extends Body> XmlResult<T> submit(String xmlData, String sign, Class<T> clazz) {
        long start = System.currentTimeMillis();
        try {
            WingsoftWebServiceStub stub = new WingsoftWebServiceStub(targetPoint);
            WingsoftWebServiceStub.Submit submit = new WingsoftWebServiceStub.Submit();
            submit.setXmlData(xmlData);
            submit.setSign(sign);
            WingsoftWebServiceStub.SubmitResponse response = stub.submit(submit);
            String xmlReturn = response.get_return();
            XmlResult<T> result = unmarshal(xmlReturn, clazz);
            log.info("[webservice submit]end,\n xmlData={},\nsign={},\nresult={},\nok={},\ncost={} ms",
                    xmlData,
                    sign,
                    xmlReturn,
                    result.isOk(),
                    (System.currentTimeMillis() - start)
            );
            return result;
        } catch (Exception e) {
            log.error("[WingsoftWebServiceStub.Submit]exception, sign={}", sign, e);
            String[] params = new String[]{xmlData, sign};
            String xmlReturn = dynamicCall("submit", params);
            XmlResult<T> result = unmarshal(xmlReturn, clazz);
            log.info("[webservice submit]end,\n xmlData={},\n sign={},\n result={},\nok={},\n cost={} ms",
                    xmlData,
                    sign,
                    xmlReturn,
                    result.isOk(),
                    (System.currentTimeMillis() - start)
            );
            return result;
        }
    }

    @Override
    public String submitStr(String xmlData) {
        String sign = CommonService.buildSign(xmlData);
        return submitStr(xmlData, sign);
    }

    @Override
    public String submitStr(String xmlData, String sign) {
        long start = System.currentTimeMillis();
        try {
            WingsoftWebServiceStub stub = new WingsoftWebServiceStub(targetPoint);
            WingsoftWebServiceStub.Submit submit = new WingsoftWebServiceStub.Submit();
            submit.setXmlData(xmlData);
            submit.setSign(sign);
            WingsoftWebServiceStub.SubmitResponse response = stub.submit(submit);
            String xmlReturn = response.get_return();
            log.info("[webservice submit]end,\n xmlData={},\nsign={},\nresult={},\ncost={} ms",
                    xmlData,
                    sign,
                    xmlReturn,
                    (System.currentTimeMillis() - start)
            );
            return xmlReturn;
        } catch (Exception e) {
            log.error("[WingsoftWebServiceStub.Submit]exception, sign={}", sign, e);
            String[] params = new String[]{xmlData, sign};
            String xmlReturn = dynamicCall("submit", params);
            log.info("[webservice submit]end,\n xmlData={},\n sign={},\n result={},\n cost={} ms",
                    xmlData,
                    sign,
                    xmlReturn,
                    (System.currentTimeMillis() - start)
            );
            return xmlReturn;
        }
    }

    @Override
    public <T> T unmarshalObj(String xml, Class<T> clazz) {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller unmar = jc.createUnmarshaller();
            T obj = (T) unmar.unmarshal(new StringReader(xml));
            return obj;
        } catch (Exception e) {
            log.error("[unmarshalObj]exception, xml={}, clazz={}", xml, clazz, e);
            return null;
        }
    }

    /**
     * 动态调用
     * @param localPart 方法名
     * @param params 方法参数
     * @throws Exception
     */
    private String dynamicCall(String localPart, Object... params){
        String wsdlUrl = targetPoint + "?wsdl";
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(wsdlUrl);
        // url为调用webService的wsdl地址
        QName name = new QName("http://webservice.wws.wingsoft.com", localPart);
        try {
            Object[] objects = client.invoke(name, params);
            return objects[0].toString();
        } catch (Exception e) {
            log.error("[dynamicCall]exception, localPart={}, params={}", localPart, params, e);
            return null;
        }
    }

    private  <T extends Body> XmlResult<T> unmarshal(String xml, Class<T> clazz) {
        XmlResult<T> result = new XmlResult<T>();
        result.setOriginXml(xml);
        try {
            if (StringUtils.isBlank(xml) || clazz == null) {
                throw new RuntimeException("请求无结果");
            }
            JAXBContext jc = JAXBContext.newInstance(ErrorResult.class, OkResult.class);
            Unmarshaller unmar = jc.createUnmarshaller();
            Object obj = unmar.unmarshal(new StringReader(xml));
            if (obj instanceof OkResult) {
                Body body = ((OkResult) obj).getData();
                if (body == null) {
                    result.setOk(true).setBody(body);
                } else if (body.getClass() == clazz) {
                    result.setOk(true).setBody( (T) body);
                } else {
                    result.setOk(false).setMessage("返回xml类型有误");
                }
            } else if (obj instanceof ErrorResult){
                result.setOk(false)
                        .setMessage(((ErrorResult) obj).getMsg())
                        .setOriginXml(xml);
            } else {
                throw new RuntimeException("错误未知");
            }
        } catch (Exception e) {
            result.setOk(false).setMessage(e.getMessage());
        }
        return result;
    }
}
