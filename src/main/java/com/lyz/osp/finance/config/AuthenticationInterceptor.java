package com.lyz.osp.finance.config;

import com.lyz.osp.finance.aspect.RequireAuth;
import com.lyz.osp.finance.exception.FinanceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringMVC提供的mvc拦截器HandlerInterceptor
 * @author xiangguijun
 */
@Component
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final String COST_PARAM = "osp-finance";

    /**
     * 在业务处理器处理请求之前被调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        String requestURI = request.getRequestURI();
        RequireAuth requireAuth = ((HandlerMethod) handler).getMethodAnnotation(RequireAuth.class);
        // 填入请求时间
        long currentTime = System.currentTimeMillis();
        request.setAttribute(COST_PARAM, currentTime);

        // 为空表示不需要验证
        if (requireAuth == null || !requireAuth.auth()) {
            return true;
        }
        String timestamp = request.getParameter("timestamp");
        String name = request.getParameter("name");
        String hash = request.getParameter("hash");

        if (StringUtils.isAnyEmpty(timestamp, name, hash)) {
            throw new FinanceException("请求参数不全");
        }

        // 30min有效 30min = 1000 * 60 * 30 ms = 1800 000 ms
        if ((currentTime - Long.parseLong(timestamp)) > 1800000) {
            throw new FinanceException("请求已超时");
        }
        log.info("osp-finance-in:uri==[{}];name==[{}];ip=[{}]", requestURI, name, getClientIP(request));
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    /* @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    } */

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
     * （主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if(!(handler instanceof HandlerMethod) || ((HandlerMethod) handler).getMethodAnnotation(RequireAuth.class) == null) {
            return;
        }
        // 统计耗时
        Long reqStartTime = (Long) request.getAttribute(COST_PARAM);
        if (reqStartTime != null) {
            long costs = System.currentTimeMillis() - reqStartTime;
            // 请求的地址URL
            String requestURI = request.getRequestURI();
            // 输出日志
            log.info("osp-finance-out:uri==[{}]; cost=[{}ms]", requestURI, costs);
        }
    }


    /**
     * X-Forwarded-For：Squid 服务代理
     * Proxy-Client-IP：apache 服务代理
     * WL-Proxy-Client-IP：weblogic 服务代理
     * HTTP_CLIENT_IP：有些代理服务器
     * X-Real-IP：nginx服务代理
     */
    static String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase("unknown", ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase("unknown", ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase("unknown", ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        // 有些网络通过多层代理，ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (StringUtils.isNotBlank(ip)) {
            ip = StringUtils.split(ip, ",")[0];
        }
        if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase("unknown", ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
