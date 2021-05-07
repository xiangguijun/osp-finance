package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 查询订单明细返回
 */
@Data
@XmlRootElement(name = "rows")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class QueryOrderDetailRes {

    /**
     * 供应商编号
     */
    @XmlElement(name = "prov_code")
    private String provCode;

    /**
     * 订单号
     */
    @XmlElement(name = "order_no")
    private String orderNo;

    /**
     * 冻结金额
     */
    @XmlElement(name = "frozen_amt")
    private Double frozenAmt;

    /**
     * 订单金额（收货确认金额）
     */
    @XmlElement(name = "order_amt")
    private Double orderAmt;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 申请结算号
     */
    @XmlElement(name = "apply_no")
    private String applyNo;

    /**
     * 申请预约单号
     */
    @XmlElement(name = "req_no")
    private String reqNo;

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
     * 支付日期
     */
    @XmlElement(name = "pay_date")
    private String payDate;

    /**
     * 订单备注
     */
    private String remark;
}
