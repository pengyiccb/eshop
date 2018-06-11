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

    public JSONResult getSkuAttrByProductCategoryId(int productCategoryId) {
        //TODO 要新增表 可选属性。 下期需求
//        Map<Integer, EShopProductSkuAttr> map = productUtils.getProductAttr(productCategoryId);
//        List<EShopProductSkuAttr> list = new ArrayList<>(map.values());
//
//        List<String> l = new ArrayList<>();
//        list.forEach(e -> {
//            if (! l.contains(e.getAttrType())) {
//                l.add(e.getAttrType());
//            }
//        });
        Map<String, Object> map = new HashMap<>();
        map.put("COLOR", "颜色");
        map.put("SIZE", "尺码");
//        List<EShopProductSkuAttr> list = select(new EShopProductSkuAttr().withProductCategoryId(productCategoryId));

        return JSONResult.ok().data(map);
    }

    public JSONResult getAllProductCategory(int vendorId) {
        //TODO 分类应该缓存 vendorId 没有使用
        List<EShopProductCategory> list = eShopProductCategoryMapper.select(null);
        return JSONResult.ok().data(list);
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
}
