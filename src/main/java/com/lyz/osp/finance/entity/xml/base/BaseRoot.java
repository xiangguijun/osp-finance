package com.lyz.osp.finance.entity.xml.base;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "root")
@XmlType(propOrder = {"head", "body"})
public class BaseRoot {

    private BaseHead head;

    private BaseBody body;
}
