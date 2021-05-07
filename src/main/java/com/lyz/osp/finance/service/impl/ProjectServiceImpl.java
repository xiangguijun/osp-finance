package com.lyz.osp.finance.service.impl;

import com.lyz.osp.finance.domain.PrjRecordInfo;
import com.lyz.osp.finance.entity.XmlResult;
import com.lyz.osp.finance.entity.xml.*;
import com.lyz.osp.finance.entity.xml.base.Body;
import com.lyz.osp.finance.enums.FuncIdEnum;
import com.lyz.osp.finance.service.CommonService;
import com.lyz.osp.finance.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private CommonService commonService;

    /**
     * 获取项目列表信息
     *
     * @param sno   工号
     * @param bCode 费用项代码
     * @param needDetail 是否需要详细信息
     * @return 项目列表
     */
    @Override
    public List<PrjRecordInfo> queryProjList(String sno, String bCode, boolean needDetail) {

        AcquireProjListReq req = new AcquireProjListReq();
        req.setSno(sno);
        req.setBCode(bCode);

        String xmlData = CommonService.xmlData(FuncIdEnum.Acquire_Proj_List.getCode(), req);
        XmlResult<PrjRecords> xmlResult = commonService.submit(xmlData, PrjRecords.class);
        if (xmlResult.isOk()) {
            PrjRecords records = xmlResult.getBody();
            if (CollectionUtils.isNotEmpty(records.getPrjRecord())) {
                List<PrjRecordInfo> result = new ArrayList<>();
                records.getPrjRecord().forEach(item -> {
                    PrjRecordInfo info = new PrjRecordInfo();
                    BeanUtils.copyProperties(item, info);
                    info.setBCode(bCode);
                    if (needDetail) {
                        XmlResult<Body> valid = validateProj(sno, bCode, item.getUniPrjCode());
                        log.info("[validateProj]end, valid={}", valid);
                        info.setValid(valid.isOk());
                        info.setMsg(valid.getMessage());
                        info.setGkMark(StringUtils.equalsIgnoreCase(item.getGkFlag(), "Y"));
                        /* if (valid.isOk()) {
                            PrjRecordDetail detail = buildProjInfo(bCode, item.getUniPrjCode());
                            if (detail != null && detail.getBudgets() != null && CollectionUtils.isNotEmpty(detail.getBudgets().getBudget())) {
                                List<PrjRecordInfo.Budget> budgets = detail.getBudgets().getBudget().stream().map(temp -> {
                                    PrjRecordInfo.Budget budget = new PrjRecordInfo.Budget();
                                    BeanUtils.copyProperties(temp, budget);
                                    return budget;
                                }).collect(Collectors.toList());
                                info.setBudgets(budgets);
                            }
                        } */
                    }
                    result.add(info);
                });
                return result;
            }
        }
        throw new RuntimeException(xmlResult.getMessage());
    }

    /**
     * 获取项目具体信息
     *
     * @param bCode    费用想代码
     * @param projCode 项目代码
     * @return
     */
    @Override
    public PrjRecordInfo queryProjByCode(String bCode, String projCode) {
        PrjRecordDetail detail = buildProjInfo(bCode, projCode);
        PrjRecordInfo info = new PrjRecordInfo();
        BeanUtils.copyProperties(detail, info, "budgets");
        info.setGkMark(StringUtils.equalsIgnoreCase(detail.getGkFlag(), "Y"));
        if (detail.getBudgets() != null && CollectionUtils.isNotEmpty(detail.getBudgets().getBudget())) {
            List<PrjRecordInfo.Budget> budgets = detail.getBudgets().getBudget().stream().map(item -> {
                PrjRecordInfo.Budget budget = new PrjRecordInfo.Budget();
                BeanUtils.copyProperties(item, budget);
                return budget;
            }).collect(Collectors.toList());
            info.setBudgets(budgets);
        }
        return info;
    }

    private PrjRecordDetail buildProjInfo(String bCode, String projCode) {
        AcquireProjDetailReq req = new AcquireProjDetailReq();
        req.setBCode(bCode);
        req.setUniPrjCode(projCode);

        String xmlData = CommonService.xmlData(FuncIdEnum.Acquire_Proj_Info.getCode(), req);
        String xmlResult = commonService.submitStr(xmlData);
        PrjRecordDetail detail = commonService.unmarshalObj(xmlResult, PrjRecordDetail.class);
        log.info("[queryProjByCode], param={},\nxml = {},\ndetail={}", req, xmlResult, detail);
        return detail;
    }

    /**
     * 验证项目是否可用
     *
     * @param sno
     * @param bCode
     * @param projCode
     * @return
     */
    private XmlResult<Body> validateProj(String sno, String bCode, String projCode) {
        ValidateProjReq req = new ValidateProjReq();
        req.setBCode(bCode);
        req.setUniPrjCode(projCode);
        req.setSno(sno);
        String xmlData = CommonService.xmlData(FuncIdEnum.Validate_Proj.getCode(), req);
        return commonService.submit(xmlData);
    }
}
