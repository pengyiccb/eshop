package com.tfx0one.frontEndModels;

import com.tfx0one.center.ProductCenter.model.EShopProduct;
import com.tfx0one.center.ProductCenter.model.EShopProductSku;

import java.util.List;

/**
 * Created by 2fx0one on 2018/6/23.
 */
public class FrontEndProduct {
    private EShopProduct product;
    List<EShopProductSku> skuList;

    public EShopProduct getProduct() {
        return product;
    }

    public void setProduct(EShopProduct product) {
        this.product = product;
    }

    public List<EShopProductSku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<EShopProductSku> skuList) {
        this.skuList = skuList;
    }

    @Override
    public String toString() {
        return "FrontEndProduct{" +
                "product=" + product +
                ", skuList=" + skuList +
                '}';
    }
}
