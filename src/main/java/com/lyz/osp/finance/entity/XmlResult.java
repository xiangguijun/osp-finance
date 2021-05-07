package com.lyz.osp.finance.entity;

import com.lyz.osp.finance.entity.xml.base.Body;
import lombok.ToString;

@ToString
public class XmlResult<T extends Body> {

    private T body;

    private boolean ok;

    private String message;

    private String originXml;

    public T getBody() {
        return body;
    }

    public XmlResult setBody(T body) {
        this.body = body;
        return this;
    }

    public boolean isOk() {
        return ok;
    }

    public XmlResult setOk(boolean ok) {
        this.ok = ok;
        return this;
    }

    public XmlResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public String getOriginXml() {
        return originXml;
    }

    public XmlResult setOriginXml(String originXml) {
        this.originXml = originXml;
        return this;
    }
}
