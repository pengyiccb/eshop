package com.tfx0one.web.service.ProductCenter;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.constant.StringConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.EShopProductSkuAttr;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


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
    public EShopProduct createProduct(EShopProduct product, List<EShopProductSku> skuList) {

        //创建根节点
        Arrays.asList(skuList.get(0).getAttrOption().split(StringConstant.SPLITTER)).parallelStream()
                .map(Integer::parseInt).forEach(
                e -> {
                    //每个元素的父节点
                    productSkuAttrService.selectById(productSkuAttrService.selectById(e).getParentId());
                }
        );

        skuList.forEach(sku-> {
            Arrays.asList(sku.getAttrOption().split(StringConstant.SPLITTER));//1|2
//            String attrs = sku.getAttrOption(); //"1|2"
        });
//        Map<Integer, EShopProductSkuAttr> root = productUtils.combinationRootAttr(skuList.get(0));
//
//        skuList.forEach(sku -> { //遍历所有单品
//            sku.getAttrs().forEach(attr -> { //遍历所有单品属性
//                List<EShopProductSkuAttr> children = root.get(attr.getParentId()).getChildren(); //找到属性的父节点保存位置。
//                if (!children.contains(attr)) {
//                    children.add(attr); //不包含就加入节点
//                }
//            });
//        });

        this.insert(product);

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
