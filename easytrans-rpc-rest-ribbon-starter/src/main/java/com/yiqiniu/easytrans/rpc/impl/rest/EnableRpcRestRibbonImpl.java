package com.yiqiniu.easytrans.rpc.impl.rest;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xudeyou
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RestRibbonEasyTransRpcConfiguration.class)
public @interface EnableRpcRestRibbonImpl {

}
