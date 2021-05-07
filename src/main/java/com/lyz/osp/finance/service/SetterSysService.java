package com.lyz.osp.finance.service;

/**
 * 结算服务
 */
public interface SetterSysService {

    /**
     * 申请结算
     */
    void apply();

    /**
     * 取消结算申请
     */
    void cancel();

    /**
     * 查询结算进度
     */
    void queryRate();

    /**
     * 查询订单进度
     */
    void queryOrder();
}
