package com.tfx0one.center.ProductCenter.serivce;

import com.tfx0one.center.ProductCenter.model.EShopProductSku;
import com.tfx0one.center.ProductCenter.model.EShopProductSkuAttr;
import com.tfx0one.common.cache.CacheUtils;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Service
public class ProductSkuAttrService extends BaseService<EShopProductSkuAttr> {

//    @Resource
//    private ProductUtils productUtils;
//
//    @Resource
//    private ProductCenter productCenter;

    @Resource
    private ProductSkuService productSkuService;

//    @Resource
//    private ProductService productService;

    @Resource
    private CacheUtils cacheUtils;


//    @Caching({
//            @CacheEvict(cacheNames = )
//    })
    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, key = "#p0.id")
    public EShopProductSkuAttr insertProductSkuAttr(EShopProductSkuAttr attr) {
        this.insert(attr);
        return attr;
    }


    //通过ID找到属性
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, key = "#p0")
    public EShopProductSkuAttr selectById(int skuId) {
        //保证类内部调用也可以启动缓存
        EShopProductSkuAttr attr = cacheUtils.get(CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, String.valueOf(skuId));
        if (attr == null) {
//            attr = this.selectOne(new EShopProductSkuAttr().withId(skuId));
            attr = this.selectByPrimaryKey(skuId);
            cacheUtils.put(CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, String.valueOf(skuId), attr);
        }
        return attr;
    }


    //获取改商品下所有单品的属性
    //格式为 [
    //  {name:"颜色","skuAttrs":[{红},{黄}]},
    //  {name:"尺码","skuAttrs":[{M},{X}]}
    // ]
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_PRODUCT_ID, key = "#p0")
    public List<EShopProductSkuAttr> selectByProductId(Integer productId) {

//        final boolean B_PLAN = false;
//        if (B_PLAN) { //8431ms
//            //方案二
//            Map<Integer, List<Integer>> attrs = (Map<Integer, List<Integer>>) new SpelExpressionParser().parseExpression(productService.selectById(productId).getAttrsSpEl()).getValue();
//            List<EShopProductSkuAttr> list = attrs.entrySet().stream().map(
//                    root -> productUtils.getSkuAttrById(root.getKey())
//                            .withChildren(
//                                    root.getValue().stream().map(
//                                            e -> productUtils.getSkuAttrById(e)
//                                    ).collect(Collectors.toList())
//                            )
//            ).collect(Collectors.toList());
//            return list;
//        } else { //3477ms

        //获取所有单品。
        List<EShopProductSku> list = productSkuService.selectByProductId(productId);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }

        //创建根节点
        Map<Integer, EShopProductSkuAttr> root = this.combinationRootAttr(list.get(0));

        list.forEach(sku -> {
            //遍历所有单品
            sku.getAttrs().forEach(attr -> {
                //遍历所有单品属性
                List<EShopProductSkuAttr> children = root.get(attr.getParentId()).getChildren();
                //找到属性的父节点保存位置。
                if (!children.contains(attr)) {
                    children.add(attr); //不包含就加入节点
                }
            });
        });
        return new ArrayList<>(root.values());
    }

    private Map<Integer, EShopProductSkuAttr> combinationRootAttr(EShopProductSku sku) {
        Map<Integer, EShopProductSkuAttr> root = new HashMap<>();
        sku.getAttrs().forEach(attr -> {
//            EShopProductSkuAttr parent = this.selectOne(new EShopProductSkuAttr().withId(attr.getParentId()).withParentId(0));
            EShopProductSkuAttr parent = this.selectById(attr.getParentId());
            parent.setChildren(new ArrayList<>());
            root.put(parent.getId(), parent);
        });
        return root;
    }


    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_VENDOR_USER_ID, key = "#p0")
    public List<EShopProductSkuAttr> getProductAttrOptionByVendorUserId(int vendorUserId) {
        //找到所有根节点 0 逻辑可以看上面 只有两级！！！
        return this.select(new EShopProductSkuAttr().withVendorUserId(vendorUserId).withParentId(0)).parallelStream().map(
                root -> root.withChildren(
                        this.select(new EShopProductSkuAttr().withParentId(root.getId()))
                )
        ).collect(Collectors.toList());
    }
}
