package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 生成的订单信息
 */
@Data
@XmlRootElement(name = "order")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class GeneOrderInfo {

    /**
     * 供应商编码
     */
    @XmlElement(name = "prov_code")
    private String provCode;

    /**
     * 订单号
     */
    @XmlElement(name = "order_no")
    private String orderNo;

    /**
     * 中间库订单号(当zc_flag=Y时有效)
     */
    @XmlElement(name = "ref_order_no")
    private String refOrderNo;

    /**
     * 冻结人
     */
    @XmlElement(name = "frozen_user")
    private String frozenUser;

    /**
     * 项目代码
     */
    @XmlElement(name = "uni_prj_code")
    private String uniPrjCode;

    /**
     * 预算项代码
     */
    @XmlElement(name = "bu_code")
    private String buCode;

    /**
     * 授权码
     */
    @XmlElement(name = "grant_id")
    private String grantId;

    /**
     * 费用项代码
     */
    @XmlElement(name = "b_code")
    private String bCode;

    /**
     * 是否资产预约单
     */
    @XmlElement(name = "zc_flag")
    private Character zcFlag;

    /**
     * 特殊核算码
     */
    @XmlElement(name = "clr_order")
    private String clrOrder;

    /**
     * 冻结金额
     */
    @XmlElement(name = "frozen_amt")
    private Double frozenAmt;

    /**
     * 冻结原因
     */
    @XmlElement(name = "frozen_remark")
    private String frozenRemark;
}
