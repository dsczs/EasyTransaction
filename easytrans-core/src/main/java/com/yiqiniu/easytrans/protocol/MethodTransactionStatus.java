package com.yiqiniu.easytrans.protocol;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * define the execute order of methods
 */
@Target({METHOD})
@Retention(RUNTIME)
public @interface MethodTransactionStatus {

    /**
     * value of com.yiqiniu.easytrans.datasource.TransStatusLogger.TransactionStatus
     * <p>
     * the default value -1 is invalid,keep the default value unchange will get an error in later processing
     *
     * @return
     */
    int value() default -1;

}
