package com.tfx0one.web.service;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.web.mapper.EShopProductMapper;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by 2fx0one on 2018/5/31.
 */
@Service
//产品
//@CacheConfig(cacheNames = CacheConstant.CACHE_PRODUCT_SPU)
public class ProductService extends BaseService<EShopProduct> {

    @Resource
    private ProductUtils productUtils;

    @Resource
    private EShopProductMapper eShopProductMapper;

    @Resource
    private ProductSkuService productSkuService;

    //缓存查询 按照商家ID 上架新商品时需要刷新
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SPU_BY_VENDOR_ID, key = "#p0")
    public List<EShopProduct> selectByVendorId(int vendorId) {
        return this.select(new EShopProduct().withVendorUserId(vendorId));
    }

    //按照商品ID缓存
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SPU_BY_ID, key = "#p0")
    public EShopProduct selectById(Integer productId) {
        EShopProduct product = this.selectOne(new EShopProduct().withId(productId));
//        productSkuAttrService.selectByProductId(productId);
        return product;
    }
//
//    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SPU_BY_ID, key = "#p0.id")
//    public EShopProduct insertProductData(EShopProduct product) {
//        eShopProductMapper.insertEShopProductAndGetID(product);
//        return product;
//    }
//
//    //更新商品数据信
//    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SPU_BY_ID, key = "#p0.id")
//    public EShopProduct updateEShopProductByID(EShopProduct product) {
//        eShopProductMapper.updateEShopProductByID(product);
//        return product;
//    }

    //创建商品
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SPU_BY_ID, key = "#p0.id")
    public EShopProduct createProduct(EShopProduct product, List<EShopProductSku> skuList) {
        eShopProductMapper.insertEShopProductAndGetID(product);

        //单品信息创建
        skuList.forEach(e -> productSkuService.insertSku(e.withProductId(product.getId())));
        return product;
    }

    //修改商品
    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SPU_BY_ID, key = "#p0.id")
    public EShopProduct modifyProduct(EShopProduct product, List<EShopProductSku> skuList) {
        this.updateNotNull(product);

        //单品信息更新
        skuList.forEach(e -> productSkuService.updateSku(e));
        return product;

    }




}
