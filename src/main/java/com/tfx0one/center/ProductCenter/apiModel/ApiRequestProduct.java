package com.tfx0one.center.ProductCenter.apiModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by 2fx0one on 2018/6/30.
 */
@ApiModel(value = "创建商品")
public class ApiRequestProduct {
    @ApiModelProperty(value = "产品的基本属性", required = true, position = 1)
    private ApiProduct product;

    @ApiModelProperty(value = "单品列表", required = true, position = 2)
    private List<ApiProductSku> skuList;

    public ApiProduct getProduct() {
        return product;
    }

    public void setProduct(ApiProduct product) {
        this.product = product;
    }

    public List<ApiProductSku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<ApiProductSku> skuList) {
        this.skuList = skuList;
    }
}
