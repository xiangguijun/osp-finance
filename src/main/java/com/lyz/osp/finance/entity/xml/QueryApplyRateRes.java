package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 查询结算进度返回
 */
@Data
@XmlRootElement(name = "return")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class QueryApplyRateRes {

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

    /**
     * 供应商名称
     */
    @XmlElement(name = "prov_name")
    private String provName;

    /**
     * 账号
     */
    private String acnt;

    /**
     * 开户行
     */
    @XmlElement(name = "accbank")
    private String accBank;

    /**
     * 联行号
     */
    @XmlElement(name = "branchcode")
    private String branchCode;

    /**
     * 申请结算金额
     */
    @XmlElement(name = "apply_amt")
    private Double applyAmt;

    /**
     * 结算申请人
     */
    @XmlElement(name = "apply_user")
    private String applyUser;

    /**
     * 结算申请时间
     */
    @XmlElement(name = "apply_date")
    private String applyDate;

    /**
     * 申请预约单号
     */
    @XmlElement(name = "req_no")
    private Long reqNo;

    /**
     * 凭证号
     */
    @XmlElement(name = "pz_uni_no")
    private String pzUniNo;

    /**
     * 支付状态(尚未支付/正在支付/支付成功/支付失败)
     */
    @XmlElement(name = "pay_status")
    private String payStatus;


    /**
     * 财务处拒绝/财务已做账/财务已做账且已复核/其他状态信息（物流等）
     */
    @XmlElement(name = "yb_status")
    private String ybStatus;

    /**
     * 拒绝原因
     */
    @XmlElement(name = "return_msg")
    private String returnMsg;

    /**
     * 支付日期
     */
    @XmlElement(name = "pay_date")
    private String payDate;

    /**
     * 入账日期
     */
    @XmlElement(name = "account_date")
    private String accountDate;


    /**
     * 凭证日期(YYYY-MM-DD)
     */
    @XmlElement(name = "pz_date")
    private String pzDate;
}
