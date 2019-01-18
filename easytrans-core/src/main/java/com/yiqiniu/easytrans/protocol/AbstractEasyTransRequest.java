package com.yiqiniu.easytrans.protocol;

import com.yiqiniu.easytrans.executor.EasyTransExecutor;

import java.io.Serializable;


public abstract class AbstractEasyTransRequest<R extends Serializable, E extends EasyTransExecutor> implements EasyTransRequest<R, E> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
