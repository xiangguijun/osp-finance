package com.lyz.osp.finance.domain;

import lombok.Data;

import java.util.List;

@Data
public class PrjRecordInfo {
    private String bCode;                   // 费用项编码
    private String uniPrjCode;              // 项目代码
    private String uniPrjName;              // 项目名称
    private String chargeSno;               // 负责人工号
    private String chargeName;              // 负责人姓名
    private String saDepart;                // 项目所属部门代码
    private String pCode;                   // 项目大类代码
    private Boolean gkMark;                 // 是否国库项目
    private String finishDate;               // 结题日期(YYYY-MM-DD)
    private String buCode;                  //  预算项
    private String buName;                  // 预算项名称
    private Double maxAmt;                  // 最大可用额度
    private String grantId;                 // 授权号
    private String grantType;               // 身份类型(0-负责人 5-限额经办人; 8-管理员; 9-无限额经办人)
    private List<Budget> budgets;           // 具体预算项
    private Boolean valid;      // 项目是否可用
    private String msg;         // 不可用原因

    @Data
    public static class Budget {
        private String buCode;      // 预算code
        private String buName;      // 预算名称
        private Double max_amt;     // 最大可用额度
        private Double balance;     // 当前剩余额度
    }
}
