package com.tfx0one.web.service;

import com.tfx0one.common.util.BaseService;
import com.tfx0one.web.model.EShopProduct;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 2fx0one on 2018/5/31.
 */
@Service
//产品
public class ProductService extends BaseService<EShopProduct> {


    public List<EShopProduct> selectByAppId(int venderUserId) {
        this.select(new EShopProduct().withVendorId(venderUserId));
    }
}
