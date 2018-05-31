package com.tfx0one.web.controller;

import com.tfx0one.common.util.AjaxObject;
import com.tfx0one.web.model.ToggeryGoods;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2fx0one on 2018/5/31.
 */

@RestController
public class ProductController {

    @ApiOperation(value = "获取主页的数据", notes = "需要传递appId 作为参数")
    @RequestMapping(value="/api/v1/wechat/productList", method = RequestMethod.GET)
    public AjaxObject productList(@RequestParam String appId) {

        List<ToggeryGoods> list = new ArrayList<>();
        ToggeryGoods g = new ToggeryGoods();
        g.setName("商品名字");
        g.setGoodsDesc("商品描述");
        g.setMarketPrice(new BigDecimal(100));

        list.add(g);
        list.add(g);
        list.add(g);
        list.add(g);

        return AjaxObject.ok().data(list);




    }

}
