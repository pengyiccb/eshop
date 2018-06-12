package com.tfx0one.common.util;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

/**
 * Created by 2fx0one on 2018/6/12.
 */
//@Component
//@RabbitListener(queues = "hello")
public class RabbitMQReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> Rec Hello" + hello);
    }
}
