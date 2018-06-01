package com.tfx0one.web.controller;

import com.tfx0one.common.util.AjaxObject;
import com.tfx0one.web.model.ToggeryGoods;
import com.tfx0one.web.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2fx0one on 2018/5/31.
 */

@RestController
public class ProductController {

    @Resource
    ProductService productService;


    @ApiOperation(value = "获取主页的数据", notes = "需要传递appId 作为参数")
    @RequestMapping(value="/api/v1/wechat/productList", method = RequestMethod.GET)
    public AjaxObject productList(@RequestParam String appId) {

        List<ToggeryGoods> list = productService.select(null);
        return AjaxObject.ok().data(list);
    }

    @ApiOperation(value = "获取商品详情", notes = "传递商品的Id")
    @RequestMapping(value="/api/v1/wechat/productDetail", method = RequestMethod.GET)
    public AjaxObject productDetail(@RequestParam Integer productId){
        ToggeryGoods good = productService.selectByPrimaryKey(productId);
        return AjaxObject.ok().data(good);
    }
}
