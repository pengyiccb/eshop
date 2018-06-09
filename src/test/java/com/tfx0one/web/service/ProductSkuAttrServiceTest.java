package com.tfx0one.web.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by 2fx0one on 2018/6/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductSkuAttrServiceTest {

    @Resource private ProductSkuAttrService productSkuAttrService;

    @Test
    public void getSkuAttrByProductCategoryId() {
       System.out.println(productSkuAttrService.getSkuAttrByProductCategoryId(1));
       System.out.println(productSkuAttrService.getAllProductCategory(123));

    }
}