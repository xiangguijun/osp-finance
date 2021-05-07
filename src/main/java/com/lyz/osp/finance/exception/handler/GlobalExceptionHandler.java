package com.lyz.osp.finance.exception.handler;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lyz.osp.finance.entity.Constants;
import com.lyz.osp.finance.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 *  Springboot RestController Global Exception Handling
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Global exception capturing and processing
     * @param ex unknown exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorHandler(HttpServletRequest req, Exception ex) {
        Map<String, Object> result = ResponseUtil.badResult(ex.getMessage());
        result.put("url", req.getRequestURL());
        result.put("params", req.getParameterMap());
        log.error("A global unhandled exception occurred in the system, message: {}, url: {}", ex.getMessage(), req.getRequestURL(), ex);
        return result;
    }

    /**
     * 处理所有接口数据验证异常
     * @param e
     * @returns
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e){
        // 打印堆栈信息
        // log.error(ThrowableUtil.getStrStackTrace(e));
        return buildResponseEntity(req, e.getBindingResult());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ApiError> handleBindException(HttpServletRequest req, BindException e){
        // 打印堆栈信息
        // log.error(ThrowableUtil.getStrStackTrace(e));
        return buildResponseEntity(req, e.getBindingResult());
    }

    private ResponseEntity<ApiError> buildResponseEntity(HttpServletRequest req, BindingResult result) {
        List<Map<String, String>> data = Lists.newArrayList();
        for (FieldError fieldError : result.getFieldErrors()) {
            Map<String, String> map = Maps.newHashMap();
            map.put("field", fieldError.getField());
            map.put("message", fieldError.getDefaultMessage());
            data.add(map);
            log.warn("valid error: obj[{}], filed[{}], message[{}]", fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
        }
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), null, req.getRequestURI(), req.getQueryString(),
                Constants.CODE_ERROR, data);
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatus()));
    }
}
