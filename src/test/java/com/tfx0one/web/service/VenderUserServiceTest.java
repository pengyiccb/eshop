package com.tfx0one.web.service;

import com.tfx0one.web.model.VendorUser;
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
public class VenderUserServiceTest {

    @Autowired
    private VenderUserService venderUserService;
    @Test
    public void selectByAppId() {
        VendorUser vendorUser = venderUserService.test("wxdda83d03c2d1521c");
        VendorUser vendorUser2 = venderUserService.test("wxdda83d03c2d1521c");
        System.out.println(vendorUser);
        System.out.println(vendorUser2);
    }
}