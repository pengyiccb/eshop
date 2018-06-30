package com.tfx0one.center.StorageCenter.controller;

import com.tfx0one.center.StorageCenter.service.StorageService;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/29.
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @ApiOperation(value = "商品详情页需要的数据，单品库存", notes = "传递单品的Id即可")
    @RequestMapping(value = "/api/v1/wechat/getProductSkuStockAmount", method = RequestMethod.GET)
    public JSONResult productSkuStockAmount(@RequestParam Integer skuId) {
        return JSONResult.ok().data(storageService.selectStockAmountBySkuId(skuId));
    }
}
