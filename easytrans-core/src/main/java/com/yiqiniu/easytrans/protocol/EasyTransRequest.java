package com.yiqiniu.easytrans.protocol;

import com.yiqiniu.easytrans.executor.EasyTransExecutor;

import java.io.Serializable;

/**
 * base interface for soft transaction parameters<br/>
 */
public interface EasyTransRequest<R extends Serializable, E extends EasyTransExecutor> extends Serializable {

}
