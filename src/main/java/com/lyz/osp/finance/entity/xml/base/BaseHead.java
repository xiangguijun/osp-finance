package com.lyz.osp.finance.entity.xml.base;

import javax.xml.bind.annotation.XmlElement;

public class BaseHead {

    private String version;

    private String userId;

    private Integer funcId;

    private String seqId;

    private String seqDatetime;

    @XmlElement
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlElement(name = "user_id", required = true)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @XmlElement(name = "func_id")
    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    @XmlElement(name = "seq_id")
    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    @XmlElement(name = "seq_datetime", required = true)
    public String getSeqDatetime() {
        return seqDatetime;
    }

    public void setSeqDatetime(String seqDatetime) {
        this.seqDatetime = seqDatetime;
    }
}
