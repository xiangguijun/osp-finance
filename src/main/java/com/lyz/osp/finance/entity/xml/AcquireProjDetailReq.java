package com.lyz.osp.finance.entity.xml;

import com.lyz.osp.finance.entity.xml.base.Body;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 获取项目具体信息入参
 */
@Data
@ToString
@XmlRootElement(name = "other_info")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class AcquireProjDetailReq extends Body {
    /**
     * 项目代码
     */
    @XmlElement(name = "uni_prj_code")
    private String uniPrjCode;

    /**
     * 费用项代码
     */
    @XmlElement(name = "b_code")
    private String bCode;
}
