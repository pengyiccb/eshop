package com.tfx0one.common.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 2fx0one on 2018/6/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductUtilsTest {
    @Autowired
    private ProductUtils productUtils;

    @Test
    public void test() {
        long s = System.currentTimeMillis();
        int times = 1000000;
        for (int i=0; i<times; ++i) {
//            productCenter.getProductSPUListByVendorId(1);
            productUtils.getProductSPU( 1);
        }
        System.out.println( "=====time======" + (System.currentTimeMillis()-s)); //19991
    }

}