package com.tfx0one.web.service;

import com.tfx0one.web.model.EShopProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 2fx0one on 2018/6/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void selectByVendorUserId() {
        List<EShopProduct> list =  (List<EShopProduct>)productService.productList("wxdda83d03c2d1521c").get("data");
        List<EShopProduct> list2 =  (List<EShopProduct>)productService.productList("wxdda83d03c2d1521c").get("data");
        list.forEach(System.out::println);
        list2.forEach(System.out::println);
    }
}