package com.lyz.osp.finance.service;

import com.lyz.osp.finance.domain.ProviderInfo;

/**
 * 供应商服务
 */
public interface ProviderService {

    /**
     * 注册供应商信息
     * @param providerInfo
     * @return 供应商编码
     */
    String register(ProviderInfo providerInfo);

    /**
     * 更新供应商信息
     * @param providerInfo
     * @return 更新是否成功
     */
    boolean updateInfo(ProviderInfo providerInfo);
}
