package com.tfx0one.center.AccountCenter.service;

import com.tfx0one.center.AccountCenter.model.EShopRole;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.constant.UserConstant;
import com.tfx0one.common.util.BaseService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2fx0one on 2018/6/22.
 */
@Service
public class RoleService extends BaseService<EShopRole> {

    @Cacheable(cacheNames = CacheConstant.CACHE_USER_ROLE_BY_ID, key = "#p0")
    public EShopRole selectUserRoleById(int roleId) {
        return this.selectByPrimaryKey(roleId);
    }

    @CachePut(cacheNames = CacheConstant.CACHE_USER_ROLE_BY_ID, key = "#p0.id")
    public EShopRole insertRole(EShopRole role) {
        this.insert(role);
        return role;
    }

    public void checkDatabaseRole() {
        //数据库中 必须包含的三个基本管理员。 id固定
        List<EShopRole> roleList = new ArrayList<>();
        roleList.add(new EShopRole()
                .withId(UserConstant.USER_ROLE_ID_ADMIN)
                .withPermissionStr(UserConstant.USER_ROLE_PERMISSION_ADMIN)
                .withTitle(UserConstant.USER_ROLE_TITLE_ADMIN));

        roleList.add(new EShopRole()
                .withId(UserConstant.USER_ROLE_ID_VENDOR)
                .withPermissionStr(UserConstant.USER_ROLE_PERMISSION_VENDOR)
                .withTitle(UserConstant.USER_ROLE_TITLE_VENDOR));

        roleList.add(new EShopRole()
                .withId(UserConstant.USER_ROLE_ID_CONSUMER)
                .withPermissionStr(UserConstant.USER_ROLE_PERMISSION_CONSUMER)
                .withTitle(UserConstant.USER_ROLE_TITLE_CONSUMER));

        roleList.stream().filter(role -> this.selectOne(role) == null).forEach(this::insert);
    }
}
