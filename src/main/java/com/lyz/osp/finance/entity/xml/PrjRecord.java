package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 项目列表具体信息
 */
@Data
// @XmlRootElement(name = "prj_record")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class PrjRecord {

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
     * 预算项
     */
    @XmlElement(name = "bu_code")
    private String buCode;

    /**
     * 预算项名称
     */
    @XmlElement(name = "bu_name")
    private String buName;

    /**
     * 可用额度
     */
    @XmlElement(name = "max_amt")
    private Double maxAmt;

    /**
     * 授权号
     */
    @XmlElement(name = "grant_id")
    private String grantId;

    /**
     * 身份类型(0-负责人 5-限额经办人; 8-管理员; 9-无限额经办人)
     */
    @XmlElement(name = "grant_type")
    private String grantType;

    /**
     * 项目属性
     */
/*    @XmlElement(name = "sa_f01")
    private String saF01;
    @XmlElement(name = "sa_f02")
    private String saF02;
    @XmlElement(name = "sa_f03")
    private String saF03;
    @XmlElement(name = "sa_f04")
    private String saF04;
    @XmlElement(name = "sa_f05")
    private String saF05;
    @XmlElement(name = "sa_f06")
    private String saF06;
    @XmlElement(name = "sa_f07")
    private String saF07;
    @XmlElement(name = "sa_f08")
    private String saF08;
    @XmlElement(name = "sa_f09")
    private String saF09;
    @XmlElement(name = "sa_f10")
    private String saF10;
    @XmlElement(name = "sa_f11")
    private String saF11;
    @XmlElement(name = "sa_f12")
    private String saF12;
    @XmlElement(name = "sa_f13")
    private String saF13;
    @XmlElement(name = "sa_f14")
    private String saF14;
    @XmlElement(name = "sa_f15")
    private String saF15;
    @XmlElement(name = "sa_f16")
    private String saF16;
    @XmlElement(name = "sa_f17")
    private String saF17;
    @XmlElement(name = "sa_f18")
    private String saF18;
    @XmlElement(name = "sa_f19")
    private String saF19;
    @XmlElement(name = "sa_f20")
    private String saF20; */
}
