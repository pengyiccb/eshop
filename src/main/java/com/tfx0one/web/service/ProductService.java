package com.tfx0one.web.service;

import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.VendorUser;
import com.tfx0one.web.mapper.EShopProductMapper;
import com.tfx0one.web.mapper.EShopProductSkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;


/**
 * Created by 2fx0one on 2018/5/31.
 */
@Service
//产品
public class ProductService extends BaseService<EShopProduct> {

    @Autowired
    private ProductUtils productUtils;

    @Autowired
    private VenderUserService venderUserService;


    //该商家的基本商品数据信息列表，不包含单品信息
    public JSONResult productList(String appId) {
        VendorUser vendorUser = venderUserService.selectByAppId(appId);
        if (vendorUser == null) {
            return JSONResult.error("商家的 appId 不存在！appId = " + appId);
        }
        Map<Integer, EShopProduct> map = productUtils.getProductSPU(vendorUser.getId());
        return JSONResult.ok().data(new ArrayList<>(map.values()));
    }

    //该商品下所有单品数据列表，详细信息
    public JSONResult productDetail(Integer productId) {
        Map<Integer, EShopProductSku> map = productUtils.getProductSKU(productId);
        if (map == null) {
            return JSONResult.error("商品 productId 不存在！productId = " + productId);
        }
        return JSONResult.ok().data(new ArrayList<>(map.values()));
    }

    @Autowired
    private EShopProductMapper eshopProductMap;

    @Autowired
    private EShopProductSkuMapper eshopProductSkuMap;

    //插入商品数据信
    public int insertProductData(EShopProduct eshopProduct) {
        eshopProduct.withBrief("");
        eshopProduct.withContentDesc("");
        eshopProduct.withImgListUrl("");
        eshopProduct.withTitle("");
        eshopProduct.withKeyword("");
        eshopProduct.withPriceUnderline(new BigDecimal(1.34));
        eshopProduct.withSortOrder(new Byte("0"));
        eshopProduct.withIsOnSale(new Byte("0"));
        eshopProduct.withIsDelete(new Byte("0"));
        eshopProduct.withProductCategoryId(1);
        eshopProduct.withVendorUserId(0);
        eshopProduct.withSubtitle("");

        eshopProductMap.insertEShopProductAndGetID(eshopProduct);

        EShopProductSku eshopProductSku = new EShopProductSku();

        eshopProductSku.withProductId(eshopProduct.getId());
        insertProductSku(eshopProductSku);

        return  0 ;
    }


    //插入商品SKU
    public int insertProductSku(EShopProductSku eshopProductSku) {
        eshopProductSku.withUnitPrice(new BigDecimal(1.34));
        eshopProductSku.withCostPrice(new BigDecimal(1.34));
        eshopProductSku.withStockAmount(0);
        eshopProductSku.withStockSn(1);
        eshopProductSku.withAttrOption("qqq");
        eshopProductSku.withSaleAmount(0);

        eshopProductSkuMap.insertEShopSKUAndGetID(eshopProductSku);

        return eshopProductSku.getId();
    }
}
