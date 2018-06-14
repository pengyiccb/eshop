package com.tfx0one.web.controller;

import com.tfx0one.common.util.JSONResult;
import com.tfx0one.web.mapper.VendorUserMapper;
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.VendorUser;
import com.tfx0one.web.service.ProductService;
import com.tfx0one.web.service.ProductSkuService;
import com.tfx0one.web.service.VenderUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/5/31.
 */

@RestController
public class ProductWeChatController {

    @Resource
    private ProductService productService;

    @Resource
    private VenderUserService venderUserService;

    @Resource
    private ProductSkuService productSkuService;


    @ApiOperation(value = "获取主页的数据, 基本数据信息，不包含单品信息", notes = "需要传递appId 作为参数")
    @RequestMapping(value = "/api/v1/wechat/productList", method = RequestMethod.GET)
    public JSONResult productList(@RequestParam String appId) {
        VendorUser vendorUser = venderUserService.selectByAppId(appId);
        if (vendorUser == null) {
            return JSONResult.error("商家的 appId 不存在！appId = " + appId);
        }
        return JSONResult.ok().data(new ArrayList<>(productService.selectByVendorId(vendorUser.getId())));
//        return productService.productList(appId);
    }

    @ApiOperation(value = "获取商品详情", notes = "传递商品的Id")
    @RequestMapping(value = "/api/v1/wechat/productDetail", method = RequestMethod.GET)
    public JSONResult productDetail(@RequestParam Integer productId) {
        return productService.productDetail(productId);
    }
}
