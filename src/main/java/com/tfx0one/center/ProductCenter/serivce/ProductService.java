package com.tfx0one.center.ProductCenter.serivce;

import com.tfx0one.center.ProductCenter.apiModel.ApiProductSku;
import com.tfx0one.center.ProductCenter.ProductCenter;
import com.tfx0one.center.ProductCenter.model.EShopProduct;
import com.tfx0one.center.ProductCenter.model.EShopProductSku;
import com.tfx0one.center.StorageCenter.service.StorageService;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
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
    private ProductSkuService productSkuService;

    @Resource
    private ProductSkuAttrService productSkuAttrService;

    @Resource
    private ProductCenter productCenter;

    @Resource
    private StorageService storageService;

    //缓存查询 按照商家ID 上架新商品时需要刷新
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SPU_BY_VENDOR_ID, key = "#p0")
    public List<EShopProduct> selectByVendorId(int vendorId) {
        return this.select(new EShopProduct().withVendorUserId(vendorId));
    }

    //按照商品ID缓存
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SPU_BY_ID, key = "#p0")
    public EShopProduct selectById(Integer productId) {
        return this.selectOne(new EShopProduct().withId(productId));
//        productSkuAttrService.selectByProductId(productId);
//        return product;
    }

    //创建商品
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SPU_BY_ID, key = "#p0.id")
    public EShopProduct createProduct(EShopProduct product, List<ApiProductSku> skuList) {

        //商品基本信息
        this.insert(product);

        //单品信息创建
        skuList.forEach(apiSku -> {
            //前端模型转换成后端
            EShopProductSku sku = apiSku.newEShopProductSku();

            productSkuService.insertSku(sku.withProductId(product.getId()));

            //库存信息
            storageService.insertSkuStock(
                    apiSku.newEShopProductSkuStock());
        });


        return product;
    }

    //修改商品
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SPU_BY_ID, key = "#p0.id")
    public EShopProduct modifyProduct(EShopProduct product, List<ApiProductSku> skuList) {

        //商品基本信息
        this.updateNotNull(product);

        //单品信息更新 只能修改
        skuList.forEach(apiSku -> {
            EShopProductSku sku = apiSku.newEShopProductSku();

            productSkuService.updateSku(sku);

            //库存信息
            storageService.updateSkuStock(
                    apiSku.newEShopProductSkuStock());
        });
        return product;

    }




}
