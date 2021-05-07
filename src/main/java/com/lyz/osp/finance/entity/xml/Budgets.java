package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
// @XmlRootElement(name = "budgets")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class Budgets {

    @XmlElement(name = "budget")
    private List<Budget> budget;
}
