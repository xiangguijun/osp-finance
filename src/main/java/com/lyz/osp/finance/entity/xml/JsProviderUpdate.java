package com.lyz.osp.finance.entity.xml;

import com.lyz.osp.finance.entity.xml.base.Body;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 注册供应商信息
 */
@Data
@XmlAccessorType(value = XmlAccessType.FIELD )
public class JsProviderUpdate extends Body {

    /**
     * 供应商编码
     */
    @XmlElement(name = "prov_code", required = true)
    private String provCode;

    /**
     * 供应商名称
     */
    @XmlElement(name = "prov_name", required = true)
    private String provName;

    /**
     * 供应商简称
     */
    @XmlElement(name = "short_name")
    private String shortName;

    /**
     * 税号
     */
    @XmlElement(name = "tax_no")
    private String taxNo;

    /**
     * 税务登记地址、开票地址
     */
    @XmlElement(name = "tax_addr")
    private String taxAddr;

    /**
     * 开票单位名称
     */
    @XmlElement(name = "invoice_name")
    private String invoiceName;

    /**
     * 账号
     */
    @XmlElement(name = "acnt", required = true)
    private String acnt;

    /**
     * 开户行
     */
    @XmlElement(name = "accbank", required = true)
    private String accBank;

    /**
     * 联行号
     */
    @XmlElement(name = "branchcode", required = true)
    private String branchCode;

    /**
     * 联系地址
     */
    @XmlElement(name = "contact_addr")
    private String contactAddr;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 手机
     */
    @XmlElement(name = "mobilephone")
    private String mobilePhone;

    /**
     * email
     */
    private String email;

    /**
     * 帐期
     */
    @XmlElement(name = "payment_days")
    private Integer paymentDays;

    /**
     * 押金
     */
    private Double deposit;

    /**
     * 是否开具电话发票
     */
    @XmlElement(name = "e_invoice", required = true)
    private Boolean eInvoice;

    /**
     * 供应商附件
     */
    @XmlElement(name = "prov_doc")
    private String provDoc;

    /**
     * 备注
     */
    private String remark;

    /**
     * 登记人
     */
    @XmlElement(name = "input_user", required = true)
    private String inputUser;
}
