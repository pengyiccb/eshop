package com.tfx0one.center.ProductCenter.controller;

import com.tfx0one.center.ProductCenter.apiModel.ApiProductSku;
import com.tfx0one.center.ProductCenter.apiModel.ApiRequestProduct;
import com.tfx0one.common.util.R;
import com.tfx0one.center.AccountCenter.AccountCenter;
import com.tfx0one.center.ProductCenter.ProductCenter;
import com.tfx0one.center.ProductCenter.model.EShopProduct;
import com.tfx0one.center.ProductCenter.model.EShopProductCategory;
import com.tfx0one.center.ProductCenter.model.EShopProductGroup;
import com.tfx0one.center.ProductCenter.model.EShopProductSkuAttr;
import com.tfx0one.center.ProductCenter.serivce.ProductGroupService;
import com.tfx0one.center.ProductCenter.serivce.ProductService;
import com.tfx0one.center.ProductCenter.serivce.ProductSkuAttrService;
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
    public R<List<EShopProductCategory>> getProductCategoryOption() {
        int vendorId = accountCenter.getCacheLoginUser().getVendorId();
//        return JSONResult.ok().data(productCenter.getCategoryByVendorId(vendorId));
        return R.ok("获取商品类目成功！", productCenter.getCategoryByVendorId(vendorId));
    }

    @ApiOperation(value = "获取商家自定义的商品分组")
    @RequestMapping(value = "/api/v1/shop/product/getGroupOption", method = RequestMethod.GET)
    public R<List<EShopProductGroup>> getProductGroupOption() {
        int vendorId = accountCenter.getCacheLoginUser().getVendorId();
//        return JSONResult.ok().data(productGroupService.getGroupByVendorId(vendorId));
        return R.ok("获取商家分组成功！", productGroupService.getGroupByVendorId(vendorId));
    }

    @ApiOperation(value = "获取商家可用分类中的可选属性", notes = "需要传递 productCategroyId 作为参数")
    @RequestMapping(value = "/api/v1/shop/product/getSkuAttrOption", method = RequestMethod.GET)
    public R<List<EShopProductSkuAttr>> getProductAttrOption() {
        int vendorId = accountCenter.getCacheLoginUser().getVendorId();
        List<EShopProductSkuAttr> list = productSkuAttrService.getProductAttrOptionByVendorUserId(vendorId);
//        return JSONResult.ok().data(list);
        return R.ok("获取商可选属性家成功！", list);
    }

    @ApiOperation(value = "增加商家可选分类中的可选属性", notes = "需要传递 productCategroyId 作为参数")
    @RequestMapping(value = "/api/v1/shop/product/productSkuAttrCreate", method = RequestMethod.POST)
    public R<List<EShopProductSkuAttr>> productSkuAttrCreate(@RequestBody EShopProductSkuAttr attr) {
        if (accountCenter.getCacheLoginUser().getVendorId() == null) {
            return R.error("商户不存在");
        }

        if (attr.getChildren() != null) {
            return R.error("属性参数 children 暂时不支持");
        }
//        if (attr.getVendorUserId() != null) {
//            return JSONResult.error("属性参数错误 vendorUserId 不需要传递！");
//        }

        if (attr.getSortOrder() == null) {
            return R.error("属性参数错误 sortOrder 不能为空");
        }

        if (attr.getAttrName() == null) {
            return R.error("属性参数错误 attrValue 不能为空");
        }

        List<EShopProductSkuAttr> list = productSkuAttrService.select(new EShopProductSkuAttr().withParentId(attr.getParentId()));
        for (EShopProductSkuAttr e : list) {
            if (attr.getAttrName().equals(e.getAttrName())) {
                return R.error("属性参数错误 attrName 不能相同");
            }
        }

        //使用用户的商户ID！
        attr.setVendorUserId(accountCenter.getCacheLoginUser().getVendorId());

        productSkuAttrService.insertProductSkuAttr(attr);

        return getProductAttrOption();
    }

    @ApiOperation(value = "创建商品", notes = "需要传递 JSON数据包装 {product:EShopProduct, skuList:List<EShopProductSku>} 作为参数")
    @RequestMapping(value = "/api/v1/shop/product/productCreate", method = RequestMethod.POST)
    public R<EShopProduct> productCreate(@RequestBody ApiRequestProduct productCreate) {
        EShopProduct product = productCreate.getProduct().newEShopProduct();

        if (product.getId() != null) {
            return R.error("参数 商品ID 创建时不需要传递！");
        }

        List<ApiProductSku> skuList = productCreate.getSkuList();

        return R.ok("创建成功！", productService.createProduct(product, skuList));

    }

    @ApiOperation(value = "修改商品", notes = "需要传递 JSON数据包装 EShopProduct EShopProductSku 作为参数")
    @RequestMapping(value = "/api/v1/shop/product/productModify", method = RequestMethod.POST)
    public R<EShopProduct> productModify(@RequestBody ApiRequestProduct productModify) {
        EShopProduct product = productModify.getProduct().newEShopProduct();

        if (product.getId() == null) {
            return R.error("参数 商品ID 创建时需要传递！");
        }

        List<ApiProductSku> skuList = productModify.getSkuList();

        return R.ok("创建成功！", productService.modifyProduct(product, skuList));
    }

}
