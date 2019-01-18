package com.yiqiniu.easytrans.log.vo;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * indicate the log is written after roll back
 */
@Target({TYPE})
@Retention(RUNTIME)
public @interface AfterRollBack {

}
