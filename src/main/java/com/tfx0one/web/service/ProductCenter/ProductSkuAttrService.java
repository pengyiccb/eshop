package com.tfx0one.web.service.ProductCenter;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.web.mapper.EShopProductSkuAttrMapper;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.EShopProductSkuAttr;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Service
public class ProductSkuAttrService extends BaseService<EShopProductSkuAttr> {

    @Resource
    private ProductUtils productUtils;

    @Resource
    private ProductSkuService productSkuService;

//    public JSONResult getAllProductCategoryOption(int vendorId) {
//        //TODO 分类应该缓存 vendorId 没有使用
//        List<EShopProductCategory> list = productCategoryService.select(null);
//        return JSONResult.ok().data(list);
//    }

//    //获取改分类下的所有选择
//    public JSONResult getSkuAttrOptionTreeByProductCategoryId(int productCategoryId) {
//        List<EShopProductSkuAttr> list = productUtils.getSkuAttrOptionTree(productCategoryId);
//
//        return JSONResult.ok().data(list);
//    }

    @Resource
    private EShopProductSkuAttrMapper eShopProductSkuAttrMapper;

    @CachePut(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, key = "#p0.id")
    public EShopProductSkuAttr insertProductSkuAttr(EShopProductSkuAttr attr) {
        this.insert(attr);
        return attr;
    }


    //通过ID找到属性
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, key = "#p0")
    public EShopProductSkuAttr selectById(int skuId) {
        return this.selectOne(new EShopProductSkuAttr().withId(skuId));
    }


    //获取改商品下所有单品的属性
    //格式为 [
    //  {name:"颜色","skuAttrs":[{红},{黄}]},
    //  {name:"尺码","skuAttrs":[{M},{X}]}
    // ]
    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_PRODUCT_ID, key = "#p0")
    public List<EShopProductSkuAttr> selectByProductId(Integer productId) {
        //获取所有单品。
        List<EShopProductSku> list = productSkuService.selectByProductId(productId);

        //创建根节点
        Map<Integer, EShopProductSkuAttr> root = productUtils.combinationRootAttr(list.get(0));

        list.forEach(sku -> { //遍历所有单品
            sku.getAttrs().forEach(attr -> { //遍历所有单品属性
                List<EShopProductSkuAttr> children = root.get(attr.getParentId()).getChildren(); //找到属性的父节点保存位置。
                if (!children.contains(attr)) {
                    children.add(attr); //不包含就加入节点
                }
            });
        });
        return new ArrayList<>(root.values());
    }

    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_USER_ACCOUNT_ID, key = "#p0")
    public List<EShopProductSkuAttr> getProductAttrOptionByUserId(int userAccountId) {
//        //找到所有根节点 0
//        List<EShopProductSkuAttr> roots = this.select(new EShopProductSkuAttr().withUserAccountId(userAccountId).withParentId(0));
//        //找到每个根节点下的子节点
//        roots.stream().forEach(
//                root -> root.setChildren(
//                        this.select(new EShopProductSkuAttr().withParentId(root.getId()))
//                )
//        );
//        return roots;
        //找到所有根节点 0 逻辑可以看上面
        return this.select(new EShopProductSkuAttr().withUserAccountId(userAccountId).withParentId(0)).parallelStream().map(
                root -> root.withChildren(
                        this.select(new EShopProductSkuAttr().withParentId(root.getId()))
                )
        ).collect(Collectors.toList());
    }
}
