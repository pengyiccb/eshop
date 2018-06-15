package com.tfx0one.common.util;

import com.tfx0one.web.service.ProductCenter.ProductCenter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 2fx0one on 2018/6/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCenterTest {

//    private static int[] range(int start,int end,int step){
//        int sz =(end-start)/step;
//        int[] result=new int[sz];
//        for(int i=0;i<sz;i++)
//            result[i]=start+(i*step);
//        return result;
//    }

    @Autowired
    private ProductCenter productCenter;

    @Test
    public void getProductSPUListByVendorId() {
        long s = System.currentTimeMillis();
        int times = 1000000;
        for (int i = 0; i < times; ++i) {
//            productCenter.getProductSPUListByVendorId(1);
        }
        System.out.println("=====time======" + (System.currentTimeMillis() - s)); //19991
    }

    @Test
    public void getProductSKUListByProductId() {
//        productCenter.getProductSKUListByProductId(1).forEach(System.out::println);
    }

    @Test
    public void getProduct() {
    }
}