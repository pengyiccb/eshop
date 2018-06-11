package com.tfx0one.web.controller;

import com.tfx0one.common.util.JSONResult;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.EShopProductSkuAttr;
import com.tfx0one.web.service.ProductService;
import com.tfx0one.web.service.ProductSkuAttrService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/9.
 */

@RestController
public class ProductVendorController {
    //商户的后台web接口

    @Resource
    private ProductSkuAttrService productSkuAttrService;

    @Resource
    private ProductService productService;

    @ApiOperation(value = "获取商家可用的商品分类", notes = "需要传递 vendorId 作为参数")
    @RequestMapping(value="/api/v1/shop/ProductCategoryOption", method = RequestMethod.GET)
    public JSONResult ProductOption(@RequestParam int vendorId) {
        return productSkuAttrService.getAllProductCategoryOption(vendorId);
    }


    @ApiOperation(value = "设置商家可选分类中的可选属性", notes = "需要传递 productCategroyId 作为参数")
    @RequestMapping(value="/api/v1/shop/setProductAttrOption", method = RequestMethod.GET)
    public JSONResult setProductAttrOption(@RequestParam EShopProductSkuAttr attr) {
        return productSkuAttrService.setSkuAttrOptionTreeByProductCategoryId(attr);
    }


    @ApiOperation(value = "获取商家可选分类中的可选属性", notes = "需要传递 productCategroyId 作为参数")
    @RequestMapping(value="/api/v1/shop/getProductAttrOption", method = RequestMethod.GET)
    public JSONResult getProductAttrOption(@RequestParam int productCategroyId) {
        return productSkuAttrService.getSkuAttrOptionTreeByProductCategoryId(productCategroyId);
    }


    @ApiOperation(value = "创建商品", notes = "需要传递 JSON数据包装 EShopProduct EShopProductSku 作为参数")
    @RequestMapping(value="/api/v1/shop/createProduct", method = RequestMethod.POST)
    public JSONResult createProduct(@RequestParam EShopProduct product,
                                    @RequestParam EShopProductSku productSku
                                    ) {
        return null;
    }

    @ApiOperation(value = "修改商品", notes = "需要传递 JSON数据包装 EShopProduct EShopProductSku 作为参数")
    @RequestMapping(value="/api/v1/shop/modifyProduct", method = RequestMethod.POST)
    public JSONResult modifyProduct(@RequestParam EShopProduct product,
                                    @RequestParam EShopProductSku productSku
    ) {
        return null;
    }

}
