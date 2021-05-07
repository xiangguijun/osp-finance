package com.lyz.osp.finance.entity.xml.base;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "return")
public class OkResult {

    private Body data;

    @XmlElementRef
    public Body getData() {
        return data;
    }

    public void setData(Body data) {
        this.data = data;
    }
}
