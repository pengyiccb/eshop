package com.tfx0one.common.util;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.EShopProductSkuAttr;
import com.tfx0one.web.service.ProductService;
import com.tfx0one.web.service.ProductSkuAttrService;
import com.tfx0one.web.service.ProductSkuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/12.
 */
@Component
public class ProductCenter {
    //    商品中心 模块
    //缓存 商品 单品相关 按照ID
    private final Logger logger = LoggerFactory.getLogger(ProductCenter.class);

    //app内的缓存
    private final EhCacheUtils ehCacheUtils;

    private final ProductService productService;

    private final ProductSkuService productSkuService;

    private final ProductSkuAttrService productSkuAttrService;

    @Autowired
    public ProductCenter(EhCacheUtils ehCacheUtils, ProductService productService, ProductSkuService productSkuService, ProductSkuAttrService productSkuAttrService) {
        this.ehCacheUtils = ehCacheUtils;
        this.productService = productService;
        this.productSkuService = productSkuService;
        this.productSkuAttrService = productSkuAttrService;
        this.refreshAllProductCacheOnce();
    }

    //通过商户ID 找到商户的产品基本信息 首页使用
    //缓存中只保存ID {vendorId : [1,2,3]}
    public List<EShopProduct> getProductSPUListByVendorId(int vendorId) {
        List<EShopProduct> list = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SPU_BY_VENDOR_ID, String.valueOf(vendorId));
        return !CollectionUtils.isEmpty(list)
                ? list
//                ? list.parallelStream().map(this::getProductSPUById).collect(Collectors.toList()) 太消耗性能了
                : refreshProductSPUListByVendorId(vendorId);
    }
    //刷新商户的基本信息，并缓存起来
    //注意，如果商户后台新增记录。这里就一定要刷新了。
    private List<EShopProduct> refreshProductSPUListByVendorId(int vendorUserId) {
        List<EShopProduct> spuList = productService.select(new EShopProduct().withVendorUserId(vendorUserId));
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU_BY_VENDOR_ID, String.valueOf(vendorUserId), spuList);
        return spuList;
    }


    //获取商品下的所有单品 点击商品详情页 使用
    //缓存中只保存ID {productSpuId : [1,2,3]}
    public List<EShopProductSku> getProductSKUListByProductId(int productSpuId) {
        List<EShopProductSku> list = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_BY_PRODUCT_ID, String.valueOf(productSpuId));
        return !CollectionUtils.isEmpty(list)
                ? list
                : refreshProductSKUListByProductId(productSpuId);
    }

    private List<EShopProductSku> refreshProductSKUListByProductId(int productSpuId) {
        List<EShopProductSku> list = productSkuService.select(new EShopProductSku().withProductId(productSpuId))
                .parallelStream()
                .map(this::injectProductSKU)
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU_BY_VENDOR_ID, String.valueOf(productSpuId), list);
        return list;
    }


    @SuppressWarnings("unchecked")
    public <T> T getProduct(Class<T> cls, int id) {
        if (cls == EShopProduct.class) {
            return (T) getProductSPUById(id);
        } else if (cls == EShopProductSku.class) {
            return (T) getProductSKUById(id);
        }
        return null;
    }

    //根据 商品ID 获取商品基本信息 缓存的是对象
    private EShopProduct getProductSPUById(int spuId) {
        EShopProduct e = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SPU_BY_ID, String.valueOf(spuId));
        return (e != null) ? e : refreshOneProductSPU(spuId);
    }

    private EShopProduct refreshOneProductSPU(int spuId) {
        EShopProduct e = productService.selectByPrimaryKey(spuId);
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU_BY_ID, String.valueOf(spuId), e);
        return e;
    }

    //根据 单品ID 获取单品的信息 缓存的对象
    private EShopProductSku getProductSKUById(int skuId) {
        EShopProductSku e = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_BY_ID, String.valueOf(skuId));
        return (e != null) ? e : refreshOneProductSKU(skuId);
    }

    private EShopProductSku refreshOneProductSKU(int skuId) {
        EShopProductSku e = productSkuService.selectByPrimaryKey(skuId);
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_BY_ID, String.valueOf(skuId), injectProductSKU(e));
        return e;
    }


    //================= 缓存 SKU单品属性 相关 单品SKU属性 按照属性ID缓存 =================
    private EShopProductSkuAttr getProductSkuAttr(int attrId) {
        EShopProductSkuAttr e = ehCacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, String.valueOf(attrId));
        return (e != null) ? e : refreshOneProductAttr(attrId);
    }

    private EShopProductSkuAttr refreshOneProductAttr(int attrId) {
        EShopProductSkuAttr e = productSkuAttrService.selectByPrimaryKey(attrId);
        ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, String.valueOf(attrId), e);
        return e;
    }

    //全部缓存，原则上只能调用一次。 顺序要注意好
    private void refreshAllProductCacheOnce() {

        //缓存所有属性
        productSkuAttrService.select(null).parallelStream()
                .forEach(e -> ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, String.valueOf(e.getId()), e));

        //缓存所有商品
        productService.select(null).parallelStream()
                .forEach(e -> ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SPU_BY_ID, String.valueOf(e.getId()), e));


        //缓存所有单品 (包含商品 和 属性） 缓存必须 在 属性和商品加载完成后再加载!!!
        productSkuService.select(null).parallelStream()
                .forEach(e -> ehCacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_BY_ID, String.valueOf(e.getId()), injectProductSKU(e)));

    }

    //这个函数依赖缓存中的商品和单品数据 getProductSPUById getProductSkuAttr
    private EShopProductSku injectProductSKU(EShopProductSku e) {
        return e
                //绑定商品到单品  商品基本信息
                .withProduct(
                        getProductSPUById(e.getProductId()))
                //遍历单品中属性 绑定到单品
                .withAttrs(
                        Arrays.asList(e.getAttrOption().split("\\|"))
                                .parallelStream()
                                .map(attr -> getProductSkuAttr(Integer.parseInt(attr)))
                                .collect(Collectors.toList())
                );
    }
}
