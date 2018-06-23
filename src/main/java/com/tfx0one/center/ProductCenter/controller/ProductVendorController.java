package com.tfx0one.center.ProductCenter.controller;

import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.ProductCenter.ProductCenter;
import com.tfx0one.center.ProductCenter.model.EShopProduct;
import com.tfx0one.center.ProductCenter.model.EShopProductSku;
import com.tfx0one.center.ProductCenter.model.EShopProductSkuAttr;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.frontEndModels.FrontEndProduct;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 2fx0one on 2018/6/9.
 */

@RestController
public class ProductVendorController {
    //商户的后台web接口

    @Resource
    private AccountCenter accountCenter;

    @Resource
    private ProductCenter productCenter;

    @ApiOperation(value = "获取商家可用的商品分类", notes = "需要传递 vendorId 作为参数")
    @RequestMapping(value = "/api/v1/shop/getProductCategoryOptionByVendorId", method = RequestMethod.GET)
    public JSONResult getProductCategoryOptionByVendorId(@RequestParam int vendorId) {
//        List<EShopProductCategory> list = productCenter.getCategoryByVendorId(vendorId);
        return JSONResult.ok().data(productCenter.getCategoryByVendorId(vendorId));
    }


    @ApiOperation(value = "增加商家可选分类中的可选属性", notes = "需要传递 productCategroyId 作为参数")
    @RequestMapping(value = "/api/v1/shop/productSkuAttrCreate", method = RequestMethod.POST)
    public JSONResult productSkuAttrCreate(@RequestBody EShopProductSkuAttr attr) {

        if (attr.getChildren() != null) {
            return JSONResult.error("属性参数 children 暂时不支持");
        }
        if (attr.getUserId() == null) {
            return JSONResult.error("属性参数错误 userAccountId 不能为空");
        }

        if (attr.getSortOrder() == null) {
            return JSONResult.error("属性参数错误 sortOrder 不能为空");
        }

        if (attr.getAttrName() == null) {
            return JSONResult.error("属性参数错误 attrName 不能为空");
        }

        //TODO: 同parent Id 下， name 不能一样。

        if (!accountCenter.getCacheLoginUser().getId().equals(attr.getUserId())) {
            return JSONResult.error("属性参数错误 user_account_id 对应用户不存在");
        }

        productCenter.createProductSkuAttr(attr);
        return JSONResult.ok("添加成功").data(attr);
    }


    @ApiOperation(value = "获取商家可选分类中的可选属性", notes = "需要传递 productCategroyId 作为参数")
    @RequestMapping(value = "/api/v1/shop/getProductAttrOptionByUserId", method = RequestMethod.GET)
    public JSONResult getProductAttrOptionByUserId(@RequestParam int userAccountId) {
        List<EShopProductSkuAttr> list = productCenter.getProductAttrOptionByUserId(userAccountId);
        return JSONResult.ok().data(list);
    }


    @ApiOperation(value = "创建商品", notes = "需要传递 JSON数据包装 {product:EShopProduct, skuList:List<EShopProductSku>} 作为参数")
    @RequestMapping(value = "/api/v1/shop/productCreate", method = RequestMethod.POST)
    public JSONResult productCreate(@RequestBody FrontEndProduct productCreate) {
        EShopProduct product = productCreate.getProduct();// JSONObject.parseObject(JSON.toJSONString(models.get("product")), EShopProduct.class);
        List<EShopProductSku> skuList = productCreate.getSkuList();

//        JSONArray array = JSONObject.parseArray(JSON.toJSONString(models.get("skuList")));
//        List<EShopProductSku> skuList = array.stream().map(
//                e -> JSONObject.parseObject(JSON.toJSONString(e), EShopProductSku.class)
//        ).collect(Collectors.toList());

        productCenter.createProduct(product, skuList);
        return JSONResult.ok().data(product);

    }

    @ApiOperation(value = "修改商品", notes = "需要传递 JSON数据包装 EShopProduct EShopProductSku 作为参数")
    @RequestMapping(value = "/api/v1/shop/productModify", method = RequestMethod.POST)
    public JSONResult productModify(@RequestBody FrontEndProduct productModify) {
        EShopProduct product = productModify.getProduct();
        List<EShopProductSku> skuList = productModify.getSkuList();
//        EShopProduct product = JSONObject.parseObject(JSON.toJSONString(models.get("product")), EShopProduct.class);
//
//        JSONArray array = JSONObject.parseArray(JSON.toJSONString(models.get("skuList")));
//        List<EShopProductSku> skuList = array.stream().map(
//                e -> JSONObject.parseObject(JSON.toJSONString(e), EShopProductSku.class)
//        ).collect(Collectors.toList());

        productCenter.modifyProduct(product, skuList);
        return JSONResult.ok().data(product);
    }

}
