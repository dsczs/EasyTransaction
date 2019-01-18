package com.yiqiniu.easytrans.protocol.aft;

import com.yiqiniu.easytrans.executor.AfterTransMethodExecutor;
import com.yiqiniu.easytrans.protocol.EasyTransRequest;

import java.io.Serializable;

public interface AfterMasterTransRequest<R extends Serializable> extends EasyTransRequest<R, AfterTransMethodExecutor> {

}
