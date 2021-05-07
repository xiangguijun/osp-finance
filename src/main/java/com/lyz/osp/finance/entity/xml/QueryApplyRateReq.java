package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 查询结算进度入参
 */
@Data
@XmlRootElement(name = "apply")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class QueryApplyRateReq {

    /**
     * 供应商编号
     */
    @XmlElement(name = "prov_code")
    private String provCode;

    /**
     * 结算申请号
     */
    @XmlElement(name = "apply_no")
    private String applyNo;

}
