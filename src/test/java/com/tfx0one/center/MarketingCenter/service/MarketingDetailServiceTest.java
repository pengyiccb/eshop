package com.tfx0one.center.MarketingCenter.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;

/**
 * Created by 2fx0one on 2018/6/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketingDetailServiceTest {

    @Resource MarketingDetailService marketingDetailService;

    @Test
    public void getSalesPriceByProductSkuId() {
        BigDecimal num = marketingDetailService.getSalesPriceBySkuId(1);
        System.out.println(num);
        System.out.println(num.doubleValue());
    }
}