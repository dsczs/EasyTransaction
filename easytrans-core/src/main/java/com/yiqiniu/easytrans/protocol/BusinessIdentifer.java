package com.yiqiniu.easytrans.protocol;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * this should add to every concrete EasyTransRequest implement
 */
@Target({TYPE})
@Retention(RUNTIME)
public @interface BusinessIdentifer {

    /**
     * find module by appId
     */
    String appId();

    /**
     * find service in module by busCode
     *
     * @return
     */
    String busCode();

    /**
     * RPC call timeout(milliseconds).
     * 0 for default setting
     *
     * @return
     */
    int rpcTimeOut() default 0;
}
