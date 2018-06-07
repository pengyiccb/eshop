package com.tfx0one.web.controller;

import com.tfx0one.common.util.JSONResult;
import com.tfx0one.web.model.VendorUser;
import com.tfx0one.web.service.ProductService;
import com.tfx0one.web.service.VenderUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/5/31.
 */

@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    @Autowired
    private VenderUserService venderUserService;

    @ApiOperation(value = "获取主页的数据, 基本数据信息，不包含单品信息", notes = "需要传递appId 作为参数")
    @RequestMapping(value="/api/v1/wechat/productList", method = RequestMethod.GET)
    public JSONResult productList(@RequestParam String appId) {
        VendorUser vendorUser = venderUserService.selectOne(new VendorUser().withAppId(appId));
        if (vendorUser == null) {
            return JSONResult.error("商家的 appId 不存在！");
        }
//        List<ToggeryGoods> list = productService.select(null);
        return JSONResult.ok().data(productService.selectByVendorUserId(vendorUser.getId()));
    }

    @ApiOperation(value = "获取商品详情", notes = "传递商品的Id")
    @RequestMapping(value="/api/v1/wechat/productDetail", method = RequestMethod.GET)
    public JSONResult productDetail(@RequestParam Integer productId){
//        ToggeryGoods good = productService.selectByPrimaryKey(productId);
        return JSONResult.ok();
    }
}
