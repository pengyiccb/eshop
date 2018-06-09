package com.tfx0one.web.service;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.util.JSONResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductSkuAttrServiceTest {

    @Resource private ProductSkuAttrService productSkuAttrService;

    @Test
    public void getSkuAttrByProductCategoryId() {
        JSONResult o = productSkuAttrService.getSkuAttrOptionTreeByProductCategoryId(1);
        System.out.println(JSONObject.toJSONString(o));
//       System.out.println(productSkuAttrService.getSkuAttrOptionByProductCategoryId(1));
       System.out.println(productSkuAttrService.getAllProductCategoryOption(123));

    }
}