package com.example.mymachan.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by 5*N on 2017/12/23
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginScoped {
}
