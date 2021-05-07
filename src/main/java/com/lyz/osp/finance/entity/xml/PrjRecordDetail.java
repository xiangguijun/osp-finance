package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 项目列表具体信息
 */
@Data
@XmlRootElement(name = "return")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class PrjRecordDetail {

    /**
     * 项目代码
     */
    @XmlElement(name = "uni_prj_code")
    private String uniPrjCode;

    /**
     * 项目名称
     */
    @XmlElement(name = "uni_prj_name")
    private String uniPrjName;

    /**
     * 负责人工号
     */
    @XmlElement(name = "charge_sno")
    private String chargeSno;

    /**
     * 负责人姓名
     */
    @XmlElement(name = "charge_name")
    private String chargeName;

    /**
     * 项目所属部门代码
     */
    @XmlElement(name = "se_depart")
    private String saDepart;

    /**
     * 项目大类代码
     */
    @XmlElement(name = "p_code")
    private String pCode;

    /**
     * 是否国库项目
     */
    @XmlElement(name = "gk_flag")
    private String gkFlag;

    /**
     * 结题日期(YYYY-MM-DD)
     */
    @XmlElement(name = "finish_date")
    private String finishDate;

    /**
     * 额度
     */
    @XmlElement(name = "max_amt")
    private Double maxAmt;

    /**
     * 剩余额度
     */
    @XmlElement(name = "balance")
    private Double balance;

    /**
     * 预算项
     */
    @XmlElement(name = "bu_code")
    private String buCode;

    /**
     * 预算项名称
     */
    @XmlElement(name = "bu_name")
    private String buName;

    @XmlElement(name = "budgets")
    private Budgets budgets;


}
