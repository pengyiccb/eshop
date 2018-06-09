package com.tfx0one.web.service;

import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.web.mapper.EShopProductCategoryMapper;
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

    //获取改分类下的所有选择
    public JSONResult getSkuAttrOptionByProductCategoryId(int productCategoryId) {
        //TODO 逻辑上 需要放到缓存中
//        Map<Integer, EShopProductSkuAttr> map = productUtils.getProductAttr(productCategoryId);
        List<EShopProductSkuAttr> list = new ArrayList<>(productUtils.getProductAttr(productCategoryId).values());
        //把list数据整理分类成如下格式
//        data={COLOR=[红, 黑], SIZE=[m, x]}
        Map<String, List<EShopProductSkuAttr>> map = new HashMap<>();
        list.forEach(e -> {
            if (! map.containsKey(e.getAttrType())) {
                map.put(e.getAttrType(), new ArrayList<>());
            }
            //加入
            if (! map.get(e.getAttrType()).contains(e)) {
                map.get(e.getAttrType()).add(e);
            }
        });



//
//        List<String> l = new ArrayList<>();
//        list.forEach(e -> {
//            if (! l.contains(e.getAttrType())) {
//                l.add(e.getAttrType());
//            }
//        });
//        Map<String, Object> map = new HashMap<>();
//        map.put("COLOR", "颜色");
//        map.put("SIZE", "尺码");
//        List<EShopProductSkuAttr> list = select(new EShopProductSkuAttr().withProductCategoryId(productCategoryId));

        return JSONResult.ok().data(map);
    }

    public JSONResult getAllProductCategoryOption(int vendorId) {
        //TODO 分类应该缓存 vendorId 没有使用
        List<EShopProductCategory> list = eShopProductCategoryMapper.select(null);
        return JSONResult.ok().data(list);
    }
}
