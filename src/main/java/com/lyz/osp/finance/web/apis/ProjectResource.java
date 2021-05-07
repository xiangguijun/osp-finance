package com.lyz.osp.finance.web.apis;

import com.lyz.osp.finance.aspect.RequireAuth;
import com.lyz.osp.finance.domain.PrjRecordInfo;
import com.lyz.osp.finance.service.ProjectService;
import com.lyz.osp.finance.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@RestController
@RequestMapping("/api/v1/project")
public class ProjectResource {

    @Autowired
    private ProjectService projectService;

    @RequireAuth
    @GetMapping("/query-list")
    public Map<String, Object> queryProjList(String sno, String bCode) {
        try {
            Map<String, Object> data = new HashMap<>(4);
            List<PrjRecordInfo> list = projectService.queryProjList(sno, bCode, true);
            AtomicReference<Double> maxAmt = new AtomicReference<>(0D);
            if (CollectionUtils.isNotEmpty(list)) {
                list.forEach(item -> {
                    if (item.getMaxAmt() != null && item.getGkMark()) {
                        maxAmt.updateAndGet(v -> v + item.getMaxAmt());
                    }
                });
            }
            data.put("items", list);
            data.put("maxAmt", maxAmt.get());
            return ResponseUtil.ok(data);
        } catch (Exception e) {
            return ResponseUtil.badResult(e.getMessage());
        }
    }

    @GetMapping("/query-info")
    public Map<String, Object> queryProjInfo(String bCode, String projCode) {
        PrjRecordInfo info = projectService.queryProjByCode(bCode, projCode);
        return ResponseUtil.ok(info);
    }
}
