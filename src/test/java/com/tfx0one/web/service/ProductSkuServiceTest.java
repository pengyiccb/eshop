package com.tfx0one.web.service;

import com.tfx0one.center.ProductCenter.serivce.ProductSkuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductSkuServiceTest {

    @Autowired
    private ProductSkuService productSkuService;
    @Test
    public void selectByVendorUserId() {
        productSkuService.selectByProductId(1).parallelStream().forEach(System.out::println);
//        List<EShopProductSku> list = productSkuService.testselectByProductId(1);
//        List<EShopProductSku> list2 = productSkuService.testselectByProductId(1);
////        List<EShopProductSku> list2 = productSkuService.selectByVendorUserId(1);
//        list.forEach(System.out::println);
//        list2.forEach(System.out::println);
////        list2.forEach(System.out::println);
    }
}