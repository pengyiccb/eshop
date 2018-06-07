package com.tfx0one.web.service;

import com.tfx0one.web.model.VendorUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.io.PrintStream;

import static org.junit.Assert.*;


/*
 * Create by 2fx0one on 1/6/18
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorServiceTest {

//    @Resource
//    VendorService vendorService;

    @Test
    public void selectByAppId() {
        try {
//            VendorUser vendorUser = vendorService.selectByVendorUserId("wxdda83d03c2d1521c");
//            VendorUser vendorUser2 = vendorService.selectByVendorUserId("wxdda83d03c2d1521c");
//            System.out.println(vendorUser.getAppSecret());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}