package com.tfx0one.web.service;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.constant.StringConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.web.model.EShopProductSku;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Service
//单品 SKU
public class ProductSkuService extends BaseService<EShopProductSku> {

    @Resource
    private ProductSkuAttrService productSkuAttrService;


    //这个函数依赖缓存中的属性数据  getProductSkuAttr
    private EShopProductSku injectProductSKU(EShopProductSku sku) {
        return sku.withAttrs(
                Arrays.stream(sku.getAttrOption().split(StringConstant.SPLITTER))
                        .map(Integer::parseInt)
                        .map(productSkuAttrService::selectById)
                        .collect(Collectors.toList()));
    }

    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_ID, key = "#p0")
    public EShopProductSku selectById(Integer skuId) {
        EShopProductSku sku = this.selectOne(new EShopProductSku().withId(skuId));
        return injectProductSKU(sku);
    }

    //单品列表 带有属性信息。后台使用
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_BY_PRODUCT_ID, key = "#p0")
    public List<EShopProductSku> selectByProductId(Integer productId) {
        List<EShopProductSku> list = this.select(new EShopProductSku().withProductId(productId));
        //无信息
//        找到父级属性值
        list.forEach(this::injectProductSKU);
//        list.forEach(e -> e.withAttrs(
//                Arrays.stream(e.getAttrOption().split(StringConstant.SPLITTER))
//                        .map(Integer::parseInt)
//                        .map(productSkuAttrService::selectById)
//                        .collect(Collectors.toList()))
//        );

//        list.parallelStream().forEach(e -> {
//                            Arrays.asList(e.getAttrOption().split("\\|"))
//                                    .parallelStream()
//                                    .map(attr -> {})
//                                    .collect(Collectors.toList())));
        //每个单品设置的商品基本信息
//            e.setProduct(product);
//            map.put(e.getId(), e);

        return list;
    }

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
