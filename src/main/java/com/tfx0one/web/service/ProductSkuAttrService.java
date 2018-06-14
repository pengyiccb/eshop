package com.tfx0one.web.service;

import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.constant.ProductSkuAttrConstant;
import com.tfx0one.common.constant.StringConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.common.util.UserAccountUtils;
import com.tfx0one.web.mapper.EShopProductCategoryMapper;
import com.tfx0one.web.model.EShopProductCategory;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.EShopProductSkuAttr;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Service
public class ProductSkuAttrService extends BaseService<EShopProductSkuAttr> {

    @Resource
    private ProductUtils productUtils;

    @Resource
    private UserAccountUtils userAccountUtils;

    @Resource
    private EShopProductCategoryMapper eShopProductCategoryMapper;

    public JSONResult getAllProductCategoryOption(int vendorId) {
        //TODO 分类应该缓存 vendorId 没有使用
        List<EShopProductCategory> list = eShopProductCategoryMapper.select(null);
        return JSONResult.ok().data(list);
    }

    //获取改分类下的所有选择
    public JSONResult getSkuAttrOptionTreeByProductCategoryId(int productCategoryId) {
        List<EShopProductSkuAttr> list = productUtils.getSkuAttrOptionTree(productCategoryId);

        return JSONResult.ok().data(list);
    }


//    @Resource
//    private EShopProductSkuAttrMapper eshopProductSkuAttrMap;
//    //插入商品SKUArr
//    public int insertProductSkuArr(EShopProductSkuAttr eshopProductSkuArr) {
//
// //       eshopProductSkuArr.withAttrContent("");
// //       eshopProductSkuArr.withAttrType("");
// //       eshopProductSkuArr.withSortOrder(0);
//        eshopProductSkuAttrMap.insertEShopSKUAttrAndGetID(eshopProductSkuArr);
//        return eshopProductSkuArr.getId();
//    }

    public JSONResult setSkuAttrOptionTreeByProductCategoryId(EShopProductSkuAttr attr) {

        if (attr.getUserAccountId() == null) {
            return JSONResult.error("属性参数错误 productCategoryId 不能为空");
        }

        if (!userAccountUtils.getCacheLoginUser().getId().equals(attr.getUserAccountId())) {
            return JSONResult.error("属性参数错误 user_account_id 对应用户不存在");
        }

        if (attr.getSortOrder() == null) {
            return JSONResult.error("属性参数错误 sortOrder 不能为空");
        }

        if (attr.getAttrName() == null) {
            return JSONResult.error("属性参数错误 attrName 不能为空");
        }

//        this.select(new EShopProductSkuAttr().withUserAccountId())
        if (!ProductSkuAttrConstant.attr.contains(attr.getAttrName())) {
//        if (!"COLOR_SIZE".contains(attr.getAttrType())) {
            return JSONResult.error("属性参数错误， 暂时只能设置 COLOR 和 SIZE 的属性， 但是设置为：" + attr.getAttrName());
        }

        //过滤一下子节点
//
        return null;
    }

    @Resource
    private ProductSkuService productSkuService;

    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_ATTR_BY_ID, key = "#p0")
    public EShopProductSkuAttr selectById(int skuId){
        return this.selectOne(new EShopProductSkuAttr().withId(skuId));
    }


    @Cacheable(cacheNames = CacheConstant.CACHE_PRODUCT_SKU_ATTR_TREE_BY_PRODUCT_ID, key = "#p0")
    public List<EShopProductSkuAttr> selectByProductId(Integer productId) {
        //获取所有单品。
        List<EShopProductSku> list = productSkuService.selectByProductId(productId);
        //创建头
        EShopProductSkuAttr attr = list.get(0).getAttrs().get(0);

        //组合单品中的数据。
//        格式为  [
        //    //  {name:"颜色","skuAttrs":[{红},{黄}]},
        //    //  {name:"尺码","skuAttrs":[{M},{X}]}
        //    // ]

        List<EShopProductSkuAttr> children = new ArrayList<>();
        list.stream().forEach(sku-> {
//            sku.getAttrs().stream().forEach(attr -> {
//                attr.getId();
//                attr.getAttrName();
//            });
//            String[] attrId = e.getAttrOption().split(StringConstant.SPLITTER);
//            EShopProductSkuAttr root = this.select(new EShopProductSkuAttr().withParentId());
        });
        return null;
    }



//    public JSONResult setSkuAttrOptionTreeByProductCategoryId(int productCategoryId, String attrType, String attrContent) {
//        return setSkuAttrOptionTreeByProductCategoryId(
//                new EShopProductSkuAttr().withProductCategoryId(productCategoryId).withAttrType(attrType).withAttrContent(attrContent));
//
//    }
}
