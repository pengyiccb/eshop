package com.tfx0one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication

//关闭JDK动态代理机制
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = {"com.tfx0one.center", "com.tfx0one.web"})
public class SpringBootEShopApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootEShopApplication.class, args);
    }
}
