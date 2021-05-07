package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "otherinfo")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class QueryOrderDetailReq {

    // wfVersion默认值
    private static final String WF_VERSION = "101";

    /**
     *
     */
    @XmlElement(name = "wf_version", required = true, defaultValue = QueryOrderDetailReq.WF_VERSION)
    private String wfVersion;

    /**
     * 订单号
     */
    @XmlElement(name = "serial_no", required = true)
    private String serialNo;
}
