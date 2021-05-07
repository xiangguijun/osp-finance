package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 生成的订单信息
 */
@Data
@XmlRootElement(name = "orders")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class GeneOrderInfos {

    private List<GeneOrderInfo> orders;

}
