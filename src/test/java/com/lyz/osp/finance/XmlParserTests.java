package com.lyz.osp.finance;

import com.lyz.osp.finance.entity.xml.PrjRecord;
import com.lyz.osp.finance.entity.xml.PrjRecords;
import com.lyz.osp.finance.entity.xml.base.ErrorResult;
import com.lyz.osp.finance.entity.xml.base.OkResult;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Profile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

@Profile("dev")
public class XmlParserTests extends OspFinanceApplicationTests{

    @Test
    public void unmarshal() throws Exception{
        String xml =  "<?xml version=\"1.0\" encoding=\"utf-8\"?><error><type>3215</type><msg>该项目不符合条件</msg></error>";
        String xml2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><return><prj_records><prj_record><uni_prj_code>3050011182128</uni_prj_code><uni_prj_name>青年教师学术启动计划</uni_prj_name><charge_sno>6120200182</charge_sno><charge_name>李潇然</charge_name><gk_flag>N</gk_flag><p_code>180</p_code><grant_id></grant_id><grant_type>0</grant_type><finish_date></finish_date><bu_code>AA01020221</bu_code><bu_name>委托业务费</bu_name><attach_act>*</attach_act><max_amt>5000</max_amt><balance>0.00</balance><sa_f01></sa_f01><sa_f02></sa_f02><sa_f03></sa_f03><sa_f04></sa_f04><sa_f05></sa_f05><sa_f06></sa_f06><sa_f07></sa_f07><sa_f08></sa_f08><sa_f09></sa_f09><sa_f10></sa_f10><sa_f11></sa_f11><sa_f12></sa_f12><sa_f13></sa_f13><sa_f14></sa_f14><sa_f15></sa_f15><sa_f16></sa_f16><sa_f17></sa_f17><sa_f18></sa_f18><sa_f19></sa_f19><sa_f20></sa_f20><attr1></attr1><attr2></attr2><attr3></attr3><attr4></attr4><sa_depart></sa_depart></prj_record><prj_record><uni_prj_code>3050012222119</uni_prj_code><uni_prj_name>国库_（2 2050205）XSQD-202105006</uni_prj_name><charge_sno>6120200182</charge_sno><charge_name>李潇然</charge_name><gk_flag>Y</gk_flag><p_code>134</p_code><grant_id></grant_id><grant_type>0</grant_type><finish_date></finish_date><bu_code>AB05020119</bu_code><bu_name>测试化验加工费</bu_name><attach_act>*</attach_act><max_amt>45500</max_amt><balance>0.00</balance><sa_f01></sa_f01><sa_f02></sa_f02><sa_f03></sa_f03><sa_f04></sa_f04><sa_f05></sa_f05><sa_f06></sa_f06><sa_f07></sa_f07><sa_f08></sa_f08><sa_f09></sa_f09><sa_f10></sa_f10><sa_f11></sa_f11><sa_f12></sa_f12><sa_f13></sa_f13><sa_f14></sa_f14><sa_f15></sa_f15><sa_f16></sa_f16><sa_f17></sa_f17><sa_f18></sa_f18><sa_f19></sa_f19><sa_f20></sa_f20><attr1></attr1><attr2></attr2><attr3></attr3><attr4></attr4><sa_depart>205</sa_depart></prj_record></prj_records></return>";
        JAXBContext jc = JAXBContext.newInstance(ErrorResult.class, OkResult.class);
        Unmarshaller unmar = jc.createUnmarshaller();
        Object obj = unmar.unmarshal(new StringReader(xml2));
        if (obj instanceof OkResult) {
            PrjRecords records = (PrjRecords) ((OkResult) obj).getData();
            List<PrjRecord> prjRecordList = records.getPrjRecord();
            prjRecordList.forEach(System.out::println);
            System.out.println("success");
        } else if (obj instanceof ErrorResult){
            System.out.println(((ErrorResult) obj).getMsg());
        } else {
            System.out.println("unknown");
        }
    }
}
