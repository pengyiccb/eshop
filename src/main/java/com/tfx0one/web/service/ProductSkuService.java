package com.tfx0one.web.service;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.web.WXModeData.ProductAttr;
import com.tfx0one.web.mapper.EShopProductSkuMapper;
import com.tfx0one.web.model.EShopProductSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.math.BigDecimal;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Service
//单品 SKU
public class ProductSkuService extends BaseService<EShopProductSku> {

    @Resource
    private ProductSkuAttrService productSkuAttrService;
    //缓存单品列表
//    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_PRODUCT_ID, key = "#p0")
//    public List<EShopProductSku> selectByProductId(Integer productId) {
//        List<EShopProductSku> list = this.select(new EShopProductSku().withProductId(productId));
//        list.parallelStream().forEach(e -> {
//                            Arrays.asList(e.getAttrOption().split("\\|"))
//                                    .parallelStream()
//                                    .map(attr -> getProductSkuAttr(productCategoryId, Integer.parseInt(attr)))
//                                    .collect(Collectors.toList())));
//            //每个单品设置的商品基本信息
////            e.setProduct(product);
////            map.put(e.getId(), e);
//
//        });
//    }

//    @Autowired
//    private ProductUtils productUtils;
//
//    public List<EShopProductSku> testselectByProductId(int productId){
//        return new ArrayList<>(productUtils.getProductSKU(productId).values());
//    }
//
//    @Resource
//    private EShopProductSkuMapper eshopProductSkuMap;
//
//    //插入商品SKU
//    public int insertProductSku(EShopProductSku eshopProductSku) {
//        //     eshopProductSku.withUnitPrice(new BigDecimal(1.34));
//        //     eshopProductSku.withCostPrice(new BigDecimal(1.34));
//        //     eshopProductSku.withStockAmount(0);
//        //     eshopProductSku.withStockSn(1);
//        //     eshopProductSku.withAttrOption("qqq");
//        //     eshopProductSku.withSaleAmount(0);
//
//        eshopProductSkuMap.insertEShopSKUAndGetID(eshopProductSku);
//
//        return eshopProductSku.getId();
//    }
//
//    //更新商品SKU
//    public void updateProductSku(EShopProductSku eshopProductSku) {
//        //     eshopProductSku.withUnitPrice(new BigDecimal(1.34));
//        //     eshopProductSku.withCostPrice(new BigDecimal(1.34));
//        //     eshopProductSku.withStockAmount(0);
//        //     eshopProductSku.withStockSn(1);
//        //     eshopProductSku.withAttrOption("qqq");
//        //     eshopProductSku.withSaleAmount(0);
//
//        eshopProductSkuMap.updateEShopSKUByID(eshopProductSku);
//
//        return ;
//    }
}
