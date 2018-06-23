package com.tfx0one.center.AccountCenter.service;

import com.tfx0one.center.AccountCenter.model.EShopRole;
import com.tfx0one.common.cache.CacheUtils;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 2fx0one on 2018/6/22.
 */
@Service
public class RoleService extends BaseService<EShopRole> {

    @Resource
    private CacheUtils cacheUtils;


    @Cacheable(cacheNames = CacheConstant.CACHE_USER_ROLE_BY_ID, key = "#p0")
    public EShopRole selectUserRoleById(int roleId) {
        //保证类内部调用也可以启动缓存
        EShopRole role = cacheUtils.get(CacheConstant.CACHE_USER_ROLE_BY_ID, String.valueOf(roleId));
        if (role == null) {
            role = this.selectByPrimaryKey(roleId);
            cacheUtils.put(CacheConstant.CACHE_USER_ROLE_BY_ID, String.valueOf(roleId), role);
        }
        return role;
    }

    @CachePut(cacheNames = CacheConstant.CACHE_USER_ROLE_BY_ID, key = "#p0.id")
    public EShopRole insertRole(EShopRole role) {
        this.insert(role.withDelFlag((byte)0));//表示有效
        return role;
    }

    //删除
//    @CacheEvict(cacheNames = CacheConstant.CACHE_ROLE_MENU_BY_ROLE_ID, allEntries = true) //删除所有用户的缓存
    @CachePut(cacheNames = CacheConstant.CACHE_USER_ROLE_BY_ID, key = "#p0")
    public EShopRole deleteRole(int id) {
        EShopRole role = this.selectUserRoleById(id);
        role.setDelFlag((byte)1);//表示删除
        this.updateNotNull(role);
        return role;
    }

    //改
    @CachePut(cacheNames = CacheConstant.CACHE_USER_ROLE_BY_ID, key = "#p0")
    public EShopRole updateRole(EShopRole role) {
        this.updateNotNull(role);
        return role;
    }


    public List<EShopRole> selectAllActiveRole() {
        return this.select(new EShopRole().withDelFlag((byte)0));
    }
}
