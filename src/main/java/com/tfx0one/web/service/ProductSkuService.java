package com.tfx0one.web.service;

import com.tfx0one.common.util.BaseService;
import com.tfx0one.web.mapper.EShopProductSkuMapper;
import com.tfx0one.web.model.EShopProductSku;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 2fx0one on 2018/6/7.
 */
@Service
//单品 SKU
public class ProductSkuService extends BaseService<EShopProductSku> {

    @Resource
    private EShopProductSkuMapper eShopProductSkuMapper;

//    public List<EShopProductSku> selectByVendorUserId(int vendorUserId){
//        return this.eShopProductSkuMapper.selectByVendorUserId(vendorUserId);
//    }

    public List<EShopProductSku> selectByProductId(int productId){
        return this.eShopProductSkuMapper.selectByProductId(productId);
    }

}
