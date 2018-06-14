package com.tfx0one.web.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.web.mapper.EShopProductMapper;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.VendorUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by 2fx0one on 2018/5/31.
 */
@Service
//产品
//@CacheConfig(cacheNames = CacheConstant.CACHE_PRODUCT_SPU)
public class ProductService extends BaseService<EShopProduct> {

    @Autowired
    private ProductUtils productUtils;

    @Autowired
    private VenderUserService venderUserService;

    @Resource
    private ProductSkuAttrService productSkuAttrService;

    //缓存查询 按照商家ID
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
    //该商家的基本商品数据信息列表，不包含单品信息
////    @Cacheable(key = "#appId+'_appId'")
//    public JSONResult productList(String appId) {
//        VendorUser vendorUser = venderUserService.selectByAppId(appId);
//        if (vendorUser == null) {
//            return JSONResult.error("商家的 appId 不存在！appId = " + appId);
//        }
////        Map<Integer, EShopProduct> map = productUtils.getProductSPU(vendorUser.getId());
//        return JSONResult.ok().data(new ArrayList<>(this.selectByVendorId(vendorUser.getId())));
//    }

    //该商品下所有单品数据列表，详细信息
//    @Cacheable(key = "#productId+'_productId'")
    public JSONResult productDetail(Integer productId) {
        Map<Integer, EShopProductSku> map = productUtils.getProductSKU(productId);
        if (map == null) {
            return JSONResult.error("商品 productId 不存在！productId = " + productId);
        }
        return JSONResult.ok().data(new ArrayList<>(map.values()));
    }

    @Resource
    private EShopProductMapper eshopProductMap;


    //插入商品数据信
//    @Caching(put = {
//
//    }, evict = {
//            @CacheEvict(cacheNames = "a", key = "#eshopProduct.vendorUserId")
//    }
//    )
//    @CachePut(key = "#eshopProduct.id+'_productId'")
    public int insertProductData(EShopProduct eshopProduct) {
        eshopProductMap.insertEShopProductAndGetID(eshopProduct);
        return eshopProduct.getId();
    }


    //更新商品数据信
    public void updateEShopProductByID(EShopProduct eshopProduct) {
        eshopProductMap.updateEShopProductByID(eshopProduct);
    }

    @Resource
    private ProductSkuService productSkuService;

    @Resource
    private EShopProductMapper eShopProductMapper;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public JSONResult createProduct(Map<String, Object> models) {
        EShopProduct product = JSONObject.parseObject(JSON.toJSONString(models.get("product")), EShopProduct.class);
        eShopProductMapper.insertEShopProductAndGetID(product);

//        List<JSONObject> skuList = JSONObject.parseObject(JSON.toJSONString(models.get("skuList")), List.class);
        JSONArray array = JSONObject.parseArray(JSON.toJSONString(models.get("skuList")));

        array.forEach(e -> {
            EShopProductSku sku = JSONObject.parseObject(JSON.toJSONString(e), EShopProductSku.class);
            System.out.println("==========" + sku);
            productSkuService.save(sku.withProductId(product.getId()));
        });

        //刷新缓存数据
        productUtils.refreshAllProduct(product.getVendorUserId(), product.getProductCategoryId(), product.getId());

        return JSONResult.ok("创建成功！");

    }

    public JSONResult modifyProduct(Map<String, Object> models) {
        EShopProduct product = JSONObject.parseObject(JSON.toJSONString(models.get("product")), EShopProduct.class);
        eShopProductMapper.updateEShopProductByID(product);

//        List<JSONObject> skuList = JSONObject.parseObject(JSON.toJSONString(models.get("skuList")), List.class);
        JSONArray array = JSONObject.parseArray(JSON.toJSONString(models.get("skuList")));

        array.forEach(e -> {
            EShopProductSku sku = JSONObject.parseObject(JSON.toJSONString(e), EShopProductSku.class);
            System.out.println("==========" + sku);
            productSkuService.updateByPrimaryKey(sku);
        });

        //刷新缓存数据
        productUtils.refreshAllProduct(product.getVendorUserId(), product.getProductCategoryId(), product.getId());

        return JSONResult.ok("修改成功！");
    }

}
