package com.lyz.osp.finance.enums;

import lombok.Getter;

/**
 * 财务WebService功能码
 */
public enum FuncIdEnum {
    /**
     * 文件上传
     */
    File_Upload(1399),
    /**
     * 文件下载
     */
    File_Download(1398),
    /**
     * 注册普通供应商
     */
    Register_Provider_Info(1301),
    /**
     * 更新普通供应商信息
     */
    Update_Provider_Info(1302),
    /**
     * 获取项目列表
     */
    Acquire_Proj_List(1311),

    /**
     * 获取项目基本信息
     */
    Acquire_Proj_Info(1312),

    /**
     * 项目验证是否可用
     */
    Validate_Proj(1313),

    /**
     * 生成订单，冻结项目额度
     */
    Generate_Order(1321),

    /**
     * 取消订单
     */
    Cancel_Order(1322),

    /**
     * 更换项目
     * 订单生成后，在收货确认前，可以调用本接口更换项目代码
     */
    Change_Proj_Order(1323),

    /**
     * 收获确认
     */
    Confirm_Order(1331),

    /**
     * 申请结算
     */
    Apply_Setter(1341),

    /**
     * 取消结算申请
     */
    Cancel_Setter(1342),

    /**
     * 查询结算进度
     */
    Query_Apply_Rate(1343),

    /**
     * 查询订单明细
     */
    Query_Order_Detail(1111);

    @Getter
    private Integer code;

    FuncIdEnum(Integer code) {
        this.code = code;
    }
}
