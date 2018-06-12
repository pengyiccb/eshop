package com.tfx0one.web.controller;

import com.tfx0one.common.util.JSONResult;
import com.tfx0one.web.model.EShopProductSkuAttr;
import com.tfx0one.web.service.ProductService;
import com.tfx0one.web.service.ProductSkuAttrService;
import com.tfx0one.web.service.ProductSkuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/9.
 */

@RestController
public class ProductVendorController {
    //商户的后台web接口

    @Resource
    private ProductSkuAttrService productSkuAttrService;

    @Resource
    private ProductSkuService productSkuService;

    @Resource
    private ProductService productService;

    @ApiOperation(value = "获取商家可用的商品分类", notes = "需要传递 vendorId 作为参数")
    @RequestMapping(value = "/api/v1/shop/ProductCategoryOption", method = RequestMethod.GET)
    public JSONResult ProductOption(@RequestParam int vendorId) {
        return productSkuAttrService.getAllProductCategoryOption(vendorId);
    }


    @ApiOperation(value = "设置商家可选分类中的可选属性", notes = "需要传递 productCategroyId 作为参数")
    @RequestMapping(value = "/api/v1/shop/setProductAttrOption", method = RequestMethod.POST)
    public JSONResult setProductAttrOption(@RequestBody EShopProductSkuAttr attr) {
        return productSkuAttrService.setSkuAttrOptionTreeByProductCategoryId(attr);
    }


    @ApiOperation(value = "获取商家可选分类中的可选属性", notes = "需要传递 productCategroyId 作为参数")
    @RequestMapping(value = "/api/v1/shop/getProductAttrOption", method = RequestMethod.GET)
    public JSONResult getProductAttrOption(@RequestParam int productCategoryId) {
        System.out.println(productCategoryId);
        return productSkuAttrService.getSkuAttrOptionTreeByProductCategoryId(productCategoryId);
    }


    @ApiOperation(value = "创建商品", notes = "需要传递 JSON数据包装 {product:EShopProduct, skuList:List<EShopProductSku>} 作为参数： \n{\"product\":\n" +
            " {\"isOnSale\":0,\"priceUnderline\":1.0,\"productCategoryId\":1,\"sortOrder\":0,\"title\":\"测试标题\",\"vendorUserId\":1},\n" +
            " \"skuList\":[\n" +
            "  {\"attrOption\":\"1|3\",\"costPrice\":1.23,\"saleAmount\":0,\"stockAmount\":0,\"unitPrice\":1.23},\n" +
            "  {\"attrOption\":\"2|3\",\"costPrice\":1.23,\"saleAmount\":0,\"stockAmount\":0,\"unitPrice\":1.23}]\n" +
            "}")
    @RequestMapping(value = "/api/v1/shop/createProduct", method = RequestMethod.POST)
    public JSONResult createProduct(@RequestBody Map<String, Object> models) {
        return productService.createProduct(models);
    }

    @ApiOperation(value = "修改商品", notes = "需要传递 JSON数据包装 EShopProduct EShopProductSku 作为参数")
    @RequestMapping(value = "/api/v1/shop/modifyProduct", method = RequestMethod.POST)
    public JSONResult modifyProduct(@RequestBody Map<String, Object> models) {
        return productService.modifyProduct(models);
    }

}
