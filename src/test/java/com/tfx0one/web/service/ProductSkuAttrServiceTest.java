package com.tfx0one.web.service;

import com.tfx0one.web.model.EShopProductSkuAttr;
import com.tfx0one.web.service.ProductCenter.ProductSkuAttrService;
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

    @Resource
    private ProductSkuAttrService productSkuAttrService;

    @Test
    public void getSkuAttrByProductCategoryId() {
        EShopProductSkuAttr e = new EShopProductSkuAttr().withParentId(1).withAttrName("a").withParentId(0).withSortOrder(0).withUserAccountId(1);
        productSkuAttrService.insert(e);
        System.out.println(e.getId());
//        JSONResult o = productSkuAttrService.getSkuAttrOptionTreeByProductCategoryId(1);
//        System.out.println(JSONObject.toJSONString(o));
//       System.out.println(productSkuAttrService.getSkuAttrOptionByProductCategoryId(1));
//        System.out.println(productSkuAttrService.getAllProductCategoryOption(123));

    }

    @Test
    public void test1() {
        productSkuAttrService.selectByProductId(1).forEach(System.out::println);
        productSkuAttrService.selectByProductId(1).forEach(System.out::println);
//        productSkuAttrService.getProductAttrOptionByUserId(1).forEach(System.out::println);
    }

    @Test
    public void test2() {
        long s = System.currentTimeMillis();
        int times = 1000000;
        for (int i=0; i<times; i++) {
            productSkuAttrService.selectByProductId(1);
        }
        System.out.println("=====time======" + (System.currentTimeMillis() - s)); //1:3477ms
    }
}