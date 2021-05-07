package com.lyz.osp.finance.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 */
@Data
class ApiError {
    /**
     * 状态码
     */
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime timestamp;

    private String message;

    private String url;

    private String params;

    private Object data;

    private String code;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(Integer status, String message) {
        this();
        this.status = status;
        this.message = message;
    }

    public ApiError(Integer status, String message, String url, String params) {
        this(status, message);
        this.url = url;
        this.params = params;
    }

    public ApiError(Integer status, String message, String url, String params, String code, Object data) {
        this(status, message, url, params);
        this.code = code;
        this.data = data;
    }
}


