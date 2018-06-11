package com.tfx0one.web.model;

import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.EShopProduct;

import javax.annotation.Resource;
import java.util.List;

public class EShopProductAndSku {
    @Resource
    public EShopProduct product;

    @Resource
    public List<EShopProductSku> productSkuList;
}
