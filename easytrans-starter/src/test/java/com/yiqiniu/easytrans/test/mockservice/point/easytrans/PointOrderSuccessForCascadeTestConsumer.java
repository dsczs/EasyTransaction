package com.yiqiniu.easytrans.test.mockservice.point.easytrans;

import com.yiqiniu.easytrans.protocol.EasyTransRequest;
import com.yiqiniu.easytrans.protocol.msg.ReliableMessageHandler;
import com.yiqiniu.easytrans.queue.consumer.EasyTransConsumeAction;
import com.yiqiniu.easytrans.test.mockservice.order.OrderMessageForCascadingTest;
import com.yiqiniu.easytrans.test.mockservice.point.PointService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PointOrderSuccessForCascadeTestConsumer implements ReliableMessageHandler<OrderMessageForCascadingTest> {

    @Resource
    private PointService pointService;


    @Override
    public EasyTransConsumeAction consume(EasyTransRequest<?, ?> request) {

        pointService.addPointForBuying((OrderMessageForCascadingTest) request);
        return EasyTransConsumeAction.CommitMessage;
//		return EasyTransConsumeAction.ReconsumeLater;
    }

    @Override
    public int getIdempotentType() {
        return IDENPOTENT_TYPE_FRAMEWORK;
    }

}
