package com.tfx0one;

import com.tfx0one.common.util.MyMapper;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.tfx0one.web.mapper", markerInterface = MyMapper.class)
@EnableCaching
public class SpringBootEShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEShopApplication.class, args);
    }
}
