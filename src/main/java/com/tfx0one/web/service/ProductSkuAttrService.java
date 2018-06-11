package com.tfx0one.web.service;

import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.web.mapper.EShopProductCategoryMapper;
import com.tfx0one.web.mapper.EShopProductSkuAttrMapper;
import com.tfx0one.web.model.EShopProductCategory;
import com.tfx0one.web.model.EShopProductSkuAttr;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//        eshopProductSkuArr.withAttrContent("");
 //       eshopProductSkuArr.withAttrType("");
 //       eshopProductSkuArr.withSortOrder(0);
        eshopProductSkuAttrMap.insertEShopSKUAttrAndGetID(eshopProductSkuArr);

        return eshopProductSkuArr.getId();
    }

    public JSONResult setSkuAttrOptionTreeByProductCategoryId(EShopProductSkuAttr attr) {
    }
}
