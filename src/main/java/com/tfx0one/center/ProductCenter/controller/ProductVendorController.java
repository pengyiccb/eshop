package com.tfx0one.center.ProductCenter.controller;

import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.ProductCenter.ProductCenter;
import com.tfx0one.center.ProductCenter.model.EShopProduct;
import com.tfx0one.center.ProductCenter.model.EShopProductSku;
import com.tfx0one.center.ProductCenter.model.EShopProductSkuAttr;
import com.tfx0one.center.ProductCenter.serivce.ProductGroupService;
import com.tfx0one.center.ProductCenter.serivce.ProductService;
import com.tfx0one.center.ProductCenter.serivce.ProductSkuAttrService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.frontEndModels.FrontEndProduct;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Resource
    private ProductSkuAttrService productSkuAttrService;

    @Resource
    private ProductService productService;

    @Resource
    private ProductGroupService productGroupService;

    @ApiOperation(value = "获取商家可用的商品类目")
    @RequestMapping(value = "/api/v1/shop/product/getCategoryOption", method = RequestMethod.GET)
    public JSONResult getProductCategoryOption() {
        int vendorId = accountCenter.getCacheLoginUser().getVendorId();
        return JSONResult.ok().data(productCenter.getCategoryByVendorId(vendorId));
    }

    @ApiOperation(value = "获取商家可用的商品分组")
    @RequestMapping(value = "/api/v1/shop/product/getGroupOption", method = RequestMethod.GET)
    public JSONResult getProductGroupOption() {
        int vendorId = accountCenter.getCacheLoginUser().getVendorId();
        return JSONResult.ok().data(productGroupService.getCategoryByVendorId(vendorId));
    }

    @ApiOperation(value = "获取商家可选分类中的可选属性", notes = "需要传递 productCategroyId 作为参数")
    @RequestMapping(value = "/api/v1/shop/product/getSkuAttrOption", method = RequestMethod.GET)
    public JSONResult getProductAttrOption() {
        int vendorId = accountCenter.getCacheLoginUser().getVendorId();
        List<EShopProductSkuAttr> list = productSkuAttrService.getProductAttrOptionByVendorUserId(vendorId);
        return JSONResult.ok().data(list);
    }

    @ApiOperation(value = "增加商家可选分类中的可选属性", notes = "需要传递 productCategroyId 作为参数")
    @RequestMapping(value = "/api/v1/shop/product/productSkuAttrCreate", method = RequestMethod.POST)
    public JSONResult productSkuAttrCreate(@RequestBody EShopProductSkuAttr attr) {
        if (accountCenter.getCacheLoginUser().getVendorId()==null) {
            return JSONResult.error("商户不存在");
        }

        if (attr.getChildren() != null) {
            return JSONResult.error("属性参数 children 暂时不支持");
        }
//        if (attr.getVendorUserId() != null) {
//            return JSONResult.error("属性参数错误 vendorUserId 不需要传递！");
//        }

        if (attr.getSortOrder() == null) {
            return JSONResult.error("属性参数错误 sortOrder 不能为空");
        }

        if (attr.getAttrName() == null) {
            return JSONResult.error("属性参数错误 attrValue 不能为空");
        }

        List<EShopProductSkuAttr> list = productSkuAttrService.select(new EShopProductSkuAttr().withParentId(attr.getParentId()));
        for (EShopProductSkuAttr e : list) {
            if (attr.getAttrName().equals(e.getAttrName())) {
                return JSONResult.error("属性参数错误 attrName 不能相同");
            }
        }

        //使用用户的商户ID！
        attr.setVendorUserId(accountCenter.getCacheLoginUser().getVendorId());

        productSkuAttrService.insertProductSkuAttr(attr);
        return JSONResult.ok("添加成功").data(productSkuAttrService.getProductAttrOptionByVendorUserId(attr.getVendorUserId()));
    }

    @ApiOperation(value = "创建商品", notes = "需要传递 JSON数据包装 {product:EShopProduct, skuList:List<EShopProductSku>} 作为参数")
    @RequestMapping(value = "/api/v1/shop/product/productCreate", method = RequestMethod.POST)
    public JSONResult productCreate(@RequestBody FrontEndProduct productCreate) {
        EShopProduct product = productCreate.getProduct();// JSONObject.parseObject(JSON.toJSONString(models.get("product")), EShopProduct.class);
        List<EShopProductSku> skuList = productCreate.getSkuList();

//        JSONArray array = JSONObject.parseArray(JSON.toJSONString(models.get("skuList")));
//        List<EShopProductSku> skuList = array.stream().map(
//                e -> JSONObject.parseObject(JSON.toJSONString(e), EShopProductSku.class)
//        ).collect(Collectors.toList());

        productService.createProduct(product, skuList);
        return JSONResult.ok().data(product);
    }

    @ApiOperation(value = "修改商品", notes = "需要传递 JSON数据包装 EShopProduct EShopProductSku 作为参数")
    @RequestMapping(value = "/api/v1/shop/product/productModify", method = RequestMethod.POST)
    public JSONResult productModify(@RequestBody FrontEndProduct productModify) {
        EShopProduct product = productModify.getProduct();
        List<EShopProductSku> skuList = productModify.getSkuList();
//        EShopProduct product = JSONObject.parseObject(JSON.toJSONString(models.get("product")), EShopProduct.class);
//
//        JSONArray array = JSONObject.parseArray(JSON.toJSONString(models.get("skuList")));
//        List<EShopProductSku> skuList = array.stream().map(
//                e -> JSONObject.parseObject(JSON.toJSONString(e), EShopProductSku.class)
//        ).collect(Collectors.toList());

        productService.modifyProduct(product, skuList);
        return JSONResult.ok().data(product);
    }

}
