package com.tfx0one.web.service;

import com.tfx0one.web.service.ProductCenter.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 2fx0one on 2018/6/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void test1() {
        //基本信息 测试
//        List<EShopProduct> list =  (List<EShopProduct>)productService.productList("wxdda83d03c2d1521c").get("data");
//        List<EShopProduct> list2 =  (List<EShopProduct>)productService.productList("wxdda83d03c2d1521c").get("data");
//        list.forEach(System.out::println);
//        list2.forEach(System.out::println);
    }

    @Test
    public void test2() {
        //详细信息 测试
//        List<EShopProductSku> list =  (List<EShopProductSku>)productService.productDetail(1).get("data");
//        List<EShopProductSku> list2 =  (List<EShopProductSku>)productService.productDetail(1).get("data");
//        list.forEach(System.out::println);
//        list2.forEach(System.out::println);

    }

    @Test
    public void test3() {
        //详细信息 测试
//        productService.insertProductData(new EShopProduct());

        System.out.println(productService.selectByVendorId(1));
        System.out.println(productService.selectByVendorId(1));



    }
}