package com.lyz.osp.finance;

import com.lyz.osp.finance.webservice.WingsoftWebServiceStub;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import javax.xml.namespace.QName;

@Profile("dev")
public class WebServiceTests extends OspFinanceApplicationTests{


    @Value("${system.webservice.targetPoint}")
    private String targetPoint;

    @Test
    public void dynamic() throws Exception{
        String wsdlUrl = targetPoint + "?wsdl";
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(wsdlUrl);
        // url为调用webService的wsdl地址
        QName name = new QName("http://webservice.wws.wingsoft.com", "getReXmlData");
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke(name, "400");
            System.out.println(objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void staticCall() throws Exception {
        WingsoftWebServiceStub stub = new WingsoftWebServiceStub(targetPoint);
        WingsoftWebServiceStub.SayHello sayHello = new WingsoftWebServiceStub.SayHello();
        sayHello.setName("lyz.osp");
        WingsoftWebServiceStub.SayHelloResponse response = stub.sayHello(sayHello);
        String s = response.get_return();
        System.out.println(s);

        WingsoftWebServiceStub.Sum sum = new WingsoftWebServiceStub.Sum();
        sum.setX(12);
        sum.setY(13);
        WingsoftWebServiceStub.SumResponse sumRes = stub.sum(sum);
        System.out.println("return:" + sumRes.get_return());

        WingsoftWebServiceStub.GetReXmlData getReXmlData = new WingsoftWebServiceStub.GetReXmlData();
        getReXmlData.setSeqId("100");
        WingsoftWebServiceStub.GetReXmlDataResponse reXmlData = stub.getReXmlData(getReXmlData);
        String resultStr = reXmlData.get_return();
        System.out.println("getReturnXmlData: " + resultStr);

//        stub.startgetReXmlData(getReXmlData, new WingsoftWebServiceCallbackHandler() {
//            @Override
//            public void receiveResultgetReXmlData(WingsoftWebServiceStub.GetReXmlDataResponse result) {
//                // result.serialize(new QName(""), null);
//                String hh = result.get_return();
//                System.out.println("getReturnXmlData sync: " + hh);
//            }
//        });
//        Thread.sleep(5000);
    }
}
