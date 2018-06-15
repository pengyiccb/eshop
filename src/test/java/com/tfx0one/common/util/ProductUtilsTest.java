package com.tfx0one.common.util;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.web.model.EShopProductSkuAttr;
import com.tfx0one.web.service.ProductCenter.ProductSkuAttrService;
import com.tfx0one.web.service.ProductCenter.ProductUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 2fx0one on 2018/6/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductUtilsTest {
    @Autowired
    private ProductUtils productUtils;

    @Resource
    private ProductSkuAttrService productSkuAttrService;

    @Test
    public void test() {
        long s = System.currentTimeMillis();
        int times = 1000000;
//        for (int i=0; i<times; ++i) {
//            productCenter.getProductSPUListByVendorId(1);
//        productUtils.getProductSPU(1).values().forEach(System.out::println);
//        }
//        System.out.println( "=====time======" + (System.currentTimeMillis()-s)); //19991
    }

    @Test
    public void test2() {
        List<EShopProductSkuAttr> skuAttrList = productSkuAttrService.select(new EShopProductSkuAttr().withUserAccountId(1).withParentId(0));

        //遍历所有根节点
        skuAttrList.parallelStream().forEach(e -> {
            //找到每个根的子节点
            e.withChildren(productSkuAttrService.select(new EShopProductSkuAttr()
                    .withUserAccountId(1)
                    .withParentId(e.getId())));
            System.out.println(e);
        });

        System.out.println(JSONObject.toJSON(skuAttrList));
    }

}