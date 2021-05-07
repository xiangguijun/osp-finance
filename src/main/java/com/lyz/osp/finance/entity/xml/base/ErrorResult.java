package com.lyz.osp.finance.entity.xml.base;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "error")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class ErrorResult {

    private Integer type;

    private String msg;

}
