package com.tfx0one.web.service;

import com.tfx0one.web.model.EShopProductSku;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

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
        List<EShopProductSku> list = productSkuService.selectByVendorUserId(1);
        list.forEach(e -> System.out.println(e));
    }
}