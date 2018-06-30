package com.tfx0one.center.ProductCenter.serivce;

import com.tfx0one.center.ProductCenter.model.EShopProductGroup;
import com.tfx0one.common.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 2fx0one on 2018/6/28.
 */
@Service
public class ProductGroupService extends BaseService<EShopProductGroup> {


    public List<EShopProductGroup> getGroupByVendorId(int vendorId){
        return this.select(new EShopProductGroup().withVendorUserId(vendorId));
    }


}
