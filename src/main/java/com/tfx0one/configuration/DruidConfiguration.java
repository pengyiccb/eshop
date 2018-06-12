package com.tfx0one.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DruidConfiguration {
    private Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);

    @Primary
    @Bean
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}