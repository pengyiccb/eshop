package com.tfx0one.common.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by 2fx0one on 2018/6/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void test1() {
        rabbitTemplate.convertAndSend("hello", "hello " + new Date());
    }

    @Test
    public void test2() {

    }
}
