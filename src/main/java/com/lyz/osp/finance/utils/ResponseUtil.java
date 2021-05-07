package com.lyz.osp.finance.utils;

import com.lyz.osp.finance.entity.Constants;

import java.util.HashMap;
import java.util.Map;


public class ResponseUtil {

    public static final String SUCCESS = Constants.CODE_SUC;
    public static final String FAILURE = Constants.CODE_ERROR;
    public static final String WARN = Constants.CODE_WARN;

    public static final String ERROR_CODE = "code";

    public static final String ERROR_MESSAGE = "message";

    public static final String DATA = "data";

    public static final String COUNT = "count";

    //-- header 常量定义 --//
    private static final String HEADER_ENCODING = "encoding";
    private static final String HEADER_NOCACHE = "no-cache";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final boolean DEFAULT_NOCACHE = true;

    public static Map<String, Object> badResult(Object message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ERROR_CODE, FAILURE);
        result.put(ERROR_MESSAGE, message);
        return result;
    }

    public static Map<String, Object> badResult(String errorCode, Object message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ERROR_CODE, errorCode);
        result.put(ERROR_MESSAGE, message);
        return result;
    }

    public static Map<String, Object> paramError(Object message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ERROR_CODE, WARN);
        result.put(ERROR_MESSAGE, message);
        return result;
    }

    public static Map<String, Object> ok() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ERROR_CODE, SUCCESS);
        result.put(ERROR_MESSAGE, "SUCCESS");
        return result;
    }

    public static Map<String, Object> warn(String message, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ERROR_CODE, WARN);
        result.put(ERROR_MESSAGE, message);
        result.put(DATA, data);
        return result;
    }

    public static Map<String, Object> ok(Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ERROR_CODE, SUCCESS);
        result.put(ERROR_MESSAGE, "SUCCESS");
        result.put(DATA, data);
        return result;
    }

    public static Map<String, Object> okWithCount(Object data, Long count) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ERROR_CODE, SUCCESS);
        result.put(DATA, data);
        result.put(COUNT, count);
        return result;
    }

    public static Map<String, Object> okWithCount(Object data, Integer count) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ERROR_CODE, SUCCESS);
        result.put(DATA, data);
        result.put(COUNT, count);
        return result;
    }
}
