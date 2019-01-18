package com.yiqiniu.easytrans.queue.consumer;

import com.yiqiniu.easytrans.protocol.EasyTransRequest;

import java.util.Map;


public interface EasyTransMsgListener {


    public EasyTransConsumeAction consume(Map<String, Object> header, EasyTransRequest<?, ?> message);
}