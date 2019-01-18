package com.yiqiniu.easytrans.protocol.cps;

import com.yiqiniu.easytrans.executor.CompensableMethodExecutor;
import com.yiqiniu.easytrans.protocol.EasyTransRequest;

import java.io.Serializable;

public interface CompensableMethodRequest<R extends Serializable> extends EasyTransRequest<R, CompensableMethodExecutor> {
}
