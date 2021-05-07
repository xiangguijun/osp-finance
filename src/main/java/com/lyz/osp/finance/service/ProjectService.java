package com.lyz.osp.finance.service;

import com.lyz.osp.finance.domain.PrjRecordInfo;

import java.util.List;

/**
 * 项目服务
 */
public interface ProjectService {

    /**
     * 获取项目列表信息
     * @param sno 工号
     * @param bCode 费用项代码
     * @param needDetail 是否需要详细信息
     * @return 项目列表
     */
    List<PrjRecordInfo> queryProjList(String sno, String bCode, boolean needDetail);

    /**
     * 获取项目具体信息
     * @param bCode 费用想代码
     * @param projCode 项目代码
     * @return
     */
    PrjRecordInfo queryProjByCode(String bCode, String projCode);

    /**
     * 验证项目是否可用
     * @param sno
     * @param bCode
     * @param projCode
     * @return
     */
    // XmlResult validateProj(String sno, String bCode, String projCode);
}
