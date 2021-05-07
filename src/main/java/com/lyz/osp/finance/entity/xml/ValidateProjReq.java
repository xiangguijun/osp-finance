package com.lyz.osp.finance.entity.xml;

import com.lyz.osp.finance.entity.xml.base.Body;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 验证项目是否可用入参
 */
@Data
@XmlRootElement(name = "other_info")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class ValidateProjReq extends Body {
    /**
     * 工号
     */
    private String sno;

    /**
     * 费用项代码
     */
    @XmlElement(name = "b_code")
    private String bCode;

    /**
     * 项目代码
     */
    @XmlElement(name = "uni_prj_code")
    private String uniPrjCode;
}
