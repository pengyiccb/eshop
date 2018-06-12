package com.tfx0one.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;


/**
 * Created by 2fx0one on 2018/6/12.
 */
//@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue hello() {
        System.out.println("=======new Queue(\"hello\");============");
        return new Queue("hello");
    }
}
