package com.lyz.osp.finance.service;

/**
 * 订单服务
 */
public interface OrderService {

    /**
     * 生成订单
     */
    void generate();

    /**
     * 取消订单
     */
    void cancel();

    /**
     * 更换项目
     */
    void change();

    /**
     * 收货确认
     */
    void confirm();
}
