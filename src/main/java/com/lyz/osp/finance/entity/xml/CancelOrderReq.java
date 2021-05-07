package com.lyz.osp.finance.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 取消订单参数
 */
@Data
@XmlRootElement(name = "orders")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class CancelOrderReq {

    private List<CancelOrder> order;

    @XmlAccessorType(value = XmlAccessType.FIELD )
    public static class CancelOrder {
        /**
         * 供应商编码
         */
        @XmlElement(name = "prov_code")
        private String provCode;

        /**
         * 订单号
         */
        @XmlElement(name = "order_no")
        private String orderNo;

        /**
         * 项目代码
         */
        @XmlElement(name = "uni_prj_code")
        private String uniPrjCode;
    }
}
