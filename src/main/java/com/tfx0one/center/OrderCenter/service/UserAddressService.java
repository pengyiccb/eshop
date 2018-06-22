package com.tfx0one.center.OrderCenter.service;

import com.tfx0one.center.AccountCenter.service.UserService;
import com.tfx0one.center.OrderCenter.model.EShopUserAddress;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wynn on 2018/6/12.
 */

@Service
public class UserAddressService extends BaseService<EShopUserAddress> {

    //@Resource
    //private EShopUserAddressMapper EShopUserAddressMapper;


    @Resource
    private UserService userService;

    public boolean checkUserAddress(Integer userId, Integer addrId){
        EShopUserAddress addrObject = this.selectOne(new EShopUserAddress().withId(addrId).withUserId(userId));
        if (addrObject == null){
            return false;
        }
        return true;
    }

    public JSONResult getAddrList(Integer userId) {
        List<EShopUserAddress> list = this.select(new EShopUserAddress().withUserId(userId));
        return JSONResult.ok().data(list);
    }

    public JSONResult getUserDefaultAddr(Integer userId) {
        EShopUserAddress addr = this.selectOne(new EShopUserAddress().withIsDefault((byte)1).withUserId(userId));
        return JSONResult.ok().data(addr);
    }

    public JSONResult modifyDefaultAddrId(Integer userId, Integer addrId) {
        if (this.checkUserAddress(userId,addrId)) {
//            userService.updateNotNull(new EShopUser().withId(userId).withUsername(addrId));
            return JSONResult.ok();
        }
        return JSONResult.error(500,"地址id不存在");
    }

    public JSONResult addrUserAddr(Integer userId, EShopUserAddress addr) {
        addr.setUserId(userId);
        //int addrid =  EShopUserAddressMapper.add(addr);
        this.insert(addr);
        if (addr.getIsDefault() == 1) {
            return modifyDefaultAddrId(userId, addr.getId());
        }
        return JSONResult.ok();
    }
}
