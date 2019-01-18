package com.yiqiniu.easytrans.test.mockservice.notification;

import com.yiqiniu.easytrans.test.mockservice.order.NotReliableOrderMessage;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    public void sendMsg(NotReliableOrderMessage msg) {
        System.out.println(String.format("user:%s used:%s", msg.getUserId(), msg.getAmount()));
    }

}
