package com.lyz.osp.finance.service;

import com.lyz.osp.finance.entity.Constants;
import com.lyz.osp.finance.entity.XmlResult;
import com.lyz.osp.finance.entity.xml.base.BaseBody;
import com.lyz.osp.finance.entity.xml.base.BaseHead;
import com.lyz.osp.finance.entity.xml.base.BaseRoot;
import com.lyz.osp.finance.entity.xml.base.Body;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface CommonService {

    /**
     * 提交
     * @param xmlData
     * @return
     */
    XmlResult<Body> submit(String xmlData);

    XmlResult<Body> submit(String xmlData, String sign);

    <T extends Body> XmlResult<T> submit(String xmlData, Class<T> clazz);

    <T extends Body> XmlResult<T> submit(String xmlData, String sign, Class<T> clazz);

    String submitStr(String xmlData);
    String submitStr(String xmlData, String sign);

    <T> T unmarshalObj(String xml, Class<T> clazz);

    static String xmlData(Integer funcId, Body data) {
        String seqId = Constants.WEB_SERVICE_USER_ID + System.currentTimeMillis();
        return xmlData(seqId, funcId, data);
    }

    /**
     * 构建请求参数
     * @param seqId 流水号
     * @param funcId 功能ID
     * @param data data
     * @return xmlData
     */
    static String xmlData(String seqId, Integer funcId, Body data) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BaseHead head = new BaseHead();
        head.setVersion(Constants.WEB_SERVICE_VERSION);
        head.setUserId(Constants.WEB_SERVICE_USER_ID);
        head.setSeqId(seqId);
        head.setSeqDatetime(dateFormat.format(new Date()));
        head.setFuncId(funcId);

        BaseBody body = new BaseBody();
        body.setData(data);

        BaseRoot root = new BaseRoot();
        root.setHead(head);
        root.setBody(body);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BaseRoot.class);
            Marshaller mar = jaxbContext.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            mar.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter writer = new StringWriter();
            writer.append(Constants.xmlHeader2);
            mar.marshal(root, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    /**
     * 构建鉴权参数
     * @param xmlData
     * @return
     */
    static String buildSign(String xmlData) {
        if (StringUtils.isNotBlank(xmlData)) {
            return DigestUtils.md5Hex(xmlData + Constants.WEB_SERVICE_KEY);
        }
        return Constants.WEB_SERVICE_KEY;
    }
}
