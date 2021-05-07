package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(value = XmlAccessType.FIELD )
public class Budget {

    /**ø
     * 预算code
     */
    @XmlElement(name = "bu_code")
    private String buCode;

    /**
     * 预算名称
     */
    @XmlElement(name = "bu_name")
    private String buName;

    /**
     * 最大可用额度
     */
    @XmlElement(name = "max_amt")
    private Double max_amt;

    /**
     * 当前剩余额度
     */
    @XmlElement(name = "balance")
    private Double balance;
}
