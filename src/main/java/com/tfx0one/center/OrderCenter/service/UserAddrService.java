package com.tfx0one.center.OrderCenter.service;

import com.tfx0one.center.AccountCenter.service.UserAccountService;
import com.tfx0one.common.util.BaseService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.center.AccountCenter.model.UserAccount;
import com.tfx0one.center.OrderCenter.model.UserAddr;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wynn on 2018/6/12.
 */

@Service
public class UserAddrService extends BaseService<UserAddr> {

    //@Resource
    //private UserAddrMapper userAddrMapper;


    @Resource
    private UserAccountService userAccountService;

    public boolean checkUserAddr(Integer userId, Integer addrId){
        UserAddr addrObject = this.selectOne(new UserAddr().withId(addrId).withUserAccount(userId));
        if (addrObject == null){
            return false;
        }
        return true;
    }

    public JSONResult getAddrList(Integer userId) {
        List<UserAddr> list = this.select(new UserAddr().withUserAccount(userId));
        return JSONResult.ok().data(list);
    }

    public JSONResult getUserDefaultAddr(Integer userId, Integer addrId) {
        UserAddr addr = this.selectOne(new UserAddr().withId(addrId).withUserAccount(userId));
        return JSONResult.ok().data(addr);
    }

    public JSONResult modifyDefaultAddrId(Integer userId, Integer addrId) {
        if (this.checkUserAddr(userId,addrId)) {
            userAccountService.updateNotNull(new UserAccount().withId(userId).withDefaultAddrId(addrId));
            return JSONResult.ok();
        }
        return JSONResult.error(500,"地址id不存在");
    }

    public JSONResult addrUserAddr(Integer userId, UserAddr addr, Integer isDefault) {
        addr.setUserAccount(userId);
        //int addrid =  userAddrMapper.add(addr);
        this.insert(addr);
        if (isDefault.intValue()==1) {
            return modifyDefaultAddrId(userId, addr.getId());
        }
        return JSONResult.ok();
    }
}
