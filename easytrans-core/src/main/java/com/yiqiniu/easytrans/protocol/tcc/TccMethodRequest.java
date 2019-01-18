package com.yiqiniu.easytrans.protocol.tcc;

import com.yiqiniu.easytrans.executor.TccMethodExecutor;
import com.yiqiniu.easytrans.protocol.EasyTransRequest;

import java.io.Serializable;

public interface TccMethodRequest<R extends Serializable> extends EasyTransRequest<R, TccMethodExecutor> {

}
