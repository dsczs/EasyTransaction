package com.yiqiniu.easytrans.test.mockservice.notification.easytrans;

import com.yiqiniu.easytrans.protocol.EasyTransRequest;
import com.yiqiniu.easytrans.protocol.msg.BestEffortMessageHandler;
import com.yiqiniu.easytrans.queue.consumer.EasyTransConsumeAction;
import com.yiqiniu.easytrans.test.mockservice.notification.NotificationService;
import com.yiqiniu.easytrans.test.mockservice.order.NotReliableOrderMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NotificationConsumer implements BestEffortMessageHandler<NotReliableOrderMessage> {

    @Resource
    private NotificationService service;

    @Override
    public EasyTransConsumeAction consume(EasyTransRequest<?, ?> request) {
        service.sendMsg((NotReliableOrderMessage) request);
        return EasyTransConsumeAction.CommitMessage;
    }

    @Override
    public int getIdempotentType() {
        return IDENPOTENT_TYPE_BUSINESS;
    }

}
