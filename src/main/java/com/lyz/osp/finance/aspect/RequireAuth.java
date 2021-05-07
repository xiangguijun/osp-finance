package com.lyz.osp.finance.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 是否需要开启业务方鉴权
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequireAuth {
    /**
     */
    boolean auth() default false;

}
