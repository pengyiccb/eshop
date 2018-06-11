package com.tfx0one.web.service;

import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.ProductUtils;
import com.tfx0one.web.mapper.EShopProductSkuMapper;
import com.tfx0one.web.model.EShopProductSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
/**
 * Created by 2fx0one on 2018/6/7.
 */
@Service
//单品 SKU
public class ProductSkuService extends BaseService<EShopProductSku> {

    @Autowired
    private ProductUtils productUtils;

    public List<EShopProductSku> testselectByProductId(int productId){
        return new ArrayList<>(productUtils.getProductSKU(productId).values());
    }

    @Resource
    private EShopProductSkuMapper eshopProductSkuMap;

    //插入商品SKU
    public int insertProductSku(EShopProductSku eshopProductSku) {
        //     eshopProductSku.withUnitPrice(new BigDecimal(1.34));
        //     eshopProductSku.withCostPrice(new BigDecimal(1.34));
        //     eshopProductSku.withStockAmount(0);
        //     eshopProductSku.withStockSn(1);
        //     eshopProductSku.withAttrOption("qqq");
        //     eshopProductSku.withSaleAmount(0);

        eshopProductSkuMap.insertEShopSKUAndGetID(eshopProductSku);

        return eshopProductSku.getId();
    }

    //更新商品SKU
    public void updateProductSku(EShopProductSku eshopProductSku) {
        //     eshopProductSku.withUnitPrice(new BigDecimal(1.34));
        //     eshopProductSku.withCostPrice(new BigDecimal(1.34));
        //     eshopProductSku.withStockAmount(0);
        //     eshopProductSku.withStockSn(1);
        //     eshopProductSku.withAttrOption("qqq");
        //     eshopProductSku.withSaleAmount(0);

        eshopProductSkuMap.updateEShopSKUByID(eshopProductSku);

        return ;
    }
}
