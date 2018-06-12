package com.tfx0one.web.service;

import com.tfx0one.common.constant.ProductSkuAttrConstant;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.web.mapper.EShopProductCategoryMapper;
import com.tfx0one.web.mapper.EShopProductSkuAttrMapper;
import com.tfx0one.web.model.EShopProductCategory;
import com.tfx0one.web.model.EShopProductSkuAttr;
import com.tfx0one.web.model.VendorUser;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

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

    @Resource
    private ProductUtils productUtils;
    @Resource
    private EShopProductCategoryMapper eShopProductCategoryMapper;

    public JSONResult getAllProductCategoryOption(int vendorId) {
        //TODO 分类应该缓存 vendorId 没有使用
        List<EShopProductCategory> list = eShopProductCategoryMapper.select(null);
        return JSONResult.ok().data(list);
    }

    //获取改分类下的所有选择
    public JSONResult getSkuAttrOptionTreeByProductCategoryId(int productCategoryId) {
        Map<String, List<EShopProductSkuAttr>> map = productUtils.getSkuAttrOptionTree(productCategoryId);

        return JSONResult.ok().data(map);
    }



    @Resource
    private EShopProductSkuAttrMapper eshopProductSkuAttrMap;
    //插入商品SKUArr
    public int insertProductSkuArr(EShopProductSkuAttr eshopProductSkuArr) {

 //       eshopProductSkuArr.withAttrContent("");
 //       eshopProductSkuArr.withAttrType("");
 //       eshopProductSkuArr.withSortOrder(0);
        eshopProductSkuAttrMap.insertEShopSKUAttrAndGetID(eshopProductSkuArr);
        return eshopProductSkuArr.getId();
    }

    public JSONResult setSkuAttrOptionTreeByProductCategoryId(EShopProductSkuAttr attr) {
        if (attr.getProductCategoryId() == null) {
            return JSONResult.error("属性参数错误 productCategoryId 不能为空");
        }

        if (attr.getSortOrder() == null) {
            return JSONResult.error("属性参数错误 sortOrder 不能为空");
        }

        if (attr.getAttrContent() == null) {
            return JSONResult.error("属性参数错误 attrContent 不能为空");
        }
        if (!ProductSkuAttrConstant.attr.containsValue(attr.getAttrType())) {
//        if (!"COLOR_SIZE".contains(attr.getAttrType())) {
            return JSONResult.error("属性参数错误， 暂时只能设置 COLOR 和 SIZE 的属性， 但是设置为：" + attr.getAttrType());
        }

        //过滤一下，相同属性 就不插入数据库了。
        List<EShopProductSkuAttr> list = productUtils.getSkuAttrOptionTree(attr.getProductCategoryId()).get(attr.getAttrType())
                .stream().filter(
                        e -> attr.getAttrType().equals(e.getAttrType()) && attr.getAttrContent().equals(e.getAttrContent())
                ).collect(Collectors.toList());

        if (list.size() > 0) {
            return JSONResult.error("属性重复 已经存在 " + attr.getAttrType() + " : " + attr.getAttrContent());
        }

        this.save(attr);

        productUtils.refreshSkuAttrOptionTree(attr.getProductCategoryId()); //刷新树状结构
        return getSkuAttrOptionTreeByProductCategoryId(attr.getProductCategoryId());
    }

//    public JSONResult setSkuAttrOptionTreeByProductCategoryId(int productCategoryId, String attrType, String attrContent) {
//        return setSkuAttrOptionTreeByProductCategoryId(
//                new EShopProductSkuAttr().withProductCategoryId(productCategoryId).withAttrType(attrType).withAttrContent(attrContent));
//
//    }
}
