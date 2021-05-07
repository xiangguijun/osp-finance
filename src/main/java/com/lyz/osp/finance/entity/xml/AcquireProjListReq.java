package com.lyz.osp.finance.entity.xml;

import com.lyz.osp.finance.entity.xml.base.Body;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 获取项目列表入参
 */
@XmlRootElement(name = "other_info")
// @XmlAccessorType(value = XmlAccessType.FIELD )
@ToString
public class AcquireProjListReq extends Body {
    /**
     * 工号
     */
    private String sno;

    /**
     * 费用项代码
     */
    private String bCode;

    @XmlElement(name = "b_code", required = true)
    public String getBCode() {
        return bCode;
    }

    public void setBCode(String bCode) {
        this.bCode = bCode;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}

