package com.lyz.osp.finance.domain;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;

/**
 * 供应商信息
 */
@Data
@ToString
public class ProviderInfo {
    private String provCode;        // 供应商编码
    private String provName;        // 供应商名称
    private String shortName;       // 供应商简称
    private String taxNo;           // 税号
    private String taxAddr;         // 税务登记地址、开票地址
    private String invoiceName;     // 开票单位名称
    private String acnt;            // 账号
    private String accBank;         // 开户行
    private String branchCode;      // 联行号
    private String contactAddr;     // 联系地址
    private String contact;         // 联系人
    private String tel;             // 联系电话
    private String mobilePhone;     // 手机
    private String email;           // email
    private Integer paymentDays;    // 帐期
    private Double deposit;         // 押金
    private Boolean eInvoice;       // 是否开具电话发票
    private String provDoc;         // 供应商附件
    private String remark;          // 备注
    private String inputUser;       // 登记人
}
