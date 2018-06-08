package com.tfx0one.web.service;

import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.EhCacheUtils;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.web.model.EShopProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tfx0one.common.constant.CacheConstant;


/**
 * Created by 2fx0one on 2018/5/31.
 */
@Service
//产品
public class ProductService extends BaseService<EShopProduct> {

    @Autowired
    private ProductUtils productUtils;

    //基本商品数据信息列表，不包含单品信息
    public List<EShopProduct> selectByVendorUserId(int vendorUserId) {
        Map<Integer, EShopProduct> map = productUtils.getProductSPU(vendorUserId);
        List<EShopProduct> list = new ArrayList<>(map.values());
        return list;
    }
}
