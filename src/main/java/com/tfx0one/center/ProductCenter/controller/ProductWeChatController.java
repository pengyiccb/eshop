package com.tfx0one.center.ProductCenter.controller;

import com.tfx0one.center.MarketingCenter.MarketingCenter;
import com.tfx0one.center.ProductCenter.ProductCenter;
import com.tfx0one.center.ProductCenter.model.EShopProduct;
import com.tfx0one.center.ProductCenter.model.EShopProductSku;
import com.tfx0one.center.ProductCenter.model.EShopProductSkuAttr;
import com.tfx0one.center.ProductCenter.serivce.ProductSkuService;
import com.tfx0one.center.VendorCenter.model.VendorUser;
import com.tfx0one.center.VendorCenter.service.VenderUserService;
import com.tfx0one.common.util.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by 2fx0one on 2018/5/31.
 */

@RestController
public class ProductWeChatController {
    @Resource
    private VenderUserService venderUserService;

    @Resource
    private ProductCenter productCenter;

    @Resource
    private ProductSkuService productSkuService;

    @Resource
    private MarketingCenter marketingCenter;

    @ApiOperation(value = "获取主页的数据, 基本数据信息，不包含单品信息", notes = "需要传递appId 作为参数")
    @RequestMapping(value = "/api/v1/wechat/getProductList", method = RequestMethod.GET)
    public JSONResult productList(@RequestParam String appId) {
        VendorUser vendorUser = venderUserService.selectByAppId(appId);
        if (vendorUser == null) {
            return JSONResult.error("商家的 appId 不存在！appId = " + appId);
        }
        return JSONResult.ok().data(productCenter.getProductListByVendorId(vendorUser.getId()));
    }

    @ApiOperation(value = "商品详情页需要的数据，整合多个单品数据", notes = "传递商品的Id即可")
    @RequestMapping(value = "/api/v1/wechat/getProductDetail", method = RequestMethod.GET)
    public JSONResult productDetail(@RequestParam Integer productId) {
        EShopProduct product = productCenter.getProductById(productId);
        if (product == null) {
            return JSONResult.error("商品 product 不存在！productId = " + productId);
        }

        //商品详情页的可选属性
        List<EShopProductSkuAttr> attrs = productCenter.getProductAttrByProductId(productId);

        Map<String, Object> map = new HashMap<>();
        map.put("product", product);
        map.put("attrs", attrs);

        return JSONResult.ok().data(map);
    }

    @ApiOperation(value = "商品详情页需要的价格", notes = "传递商品的Id和属性字符串")
    @RequestMapping(value = "/api/v1/wechat/getProductDetailPrice", method = RequestMethod.GET)
    public JSONResult getProductDetailPrice(@RequestParam Integer productId/*, @RequestParam String attrOption*/) {
        List<EShopProductSku> skuList = productSkuService.selectByProductId(productId);
        skuList = skuList.stream().map(e -> e.withUnitPrice(marketingCenter.getSalesPriceBySkuId(e.getId()))
        ).collect(Collectors.toList());
        return JSONResult.ok().data(skuList);
    }
}
