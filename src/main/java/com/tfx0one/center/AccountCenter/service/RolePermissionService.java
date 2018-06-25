package com.tfx0one.center.AccountCenter.service;

import com.tfx0one.center.AccountCenter.mapper.EShopRolePermissionMapper;
import com.tfx0one.center.AccountCenter.model.EShopRolePermission;
import com.tfx0one.common.cache.CacheUtils;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.constant.UserConstant;
import com.tfx0one.common.util.BaseService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/22.
 */
@Service
public class RolePermissionService extends BaseService<EShopRolePermission> {

    @Resource
    private EShopRolePermissionMapper eShopRolePermissionMapper;

    @Resource
    private CacheUtils cacheUtils;


    //基本的获取 根据id获取菜单。
    @Cacheable(cacheNames = CacheConstant.CACHE_ROLE_PERMISSION_BY_ID, key = "#p0")
    public EShopRolePermission selectRolePermissionById(int meunId) {
        //保证类内部调用也可以启动缓存
        EShopRolePermission Permission = cacheUtils.get(CacheConstant.CACHE_ROLE_PERMISSION_BY_ID, String.valueOf(meunId));
        if (Permission == null) {
            Permission = this.selectByPrimaryKey(meunId);
            cacheUtils.put(CacheConstant.CACHE_ROLE_PERMISSION_BY_ID, String.valueOf(meunId), Permission);
        }
        return Permission;
    }

    //用户缓存菜单树
    @Cacheable(cacheNames = CacheConstant.CACHE_ROLE_PERMISSION_BY_ROLE_ID, key = "#p0")
    public List<EShopRolePermission> selectRolePermissionByRoleId(int roleId) {
        if (roleId == UserConstant.USER_ROLE_ID_ADMIN) { //超级管理员获取 整个菜单树 只支持两级 ！！！
            return selectAllActiveRolePermission();
        }
        List<EShopRolePermission> Permissions = eShopRolePermissionMapper.selectRolePermissionByRoleId(roleId);

        //由于只有两级 故而先构建根节点 再遍历子节点
        return Permissions.stream()
                .filter(e -> e.getParentId().equals(0) && e.getDelFlag()==0
                ).map(root -> //遍历根节点 第一级
                        root.withChildren(
                                Permissions.stream() //找到所有是这个父节点的子节点 第二级
                                        .filter(child -> child.getParentId().equals(root.getId()) && child.getDelFlag()==0
                                        ).collect(Collectors.toList())
                        )
                ).collect(Collectors.toList());
    }

    //超级管理员获取 获取权限列表 {url:[roleIdList]}
    public Map<String, List<String>> selectAllActiveURLRolePermission() {
         eShopRolePermissionMapper.selectAllActiveURLRolePermission();
         return null;

    }
    //超级管理员获取 整个菜单树 只支持两级 ！！！
    public List<EShopRolePermission> selectAllActiveRolePermission(){
        return this.select(new EShopRolePermission().withParentId(0).withDelFlag((byte)0)).parallelStream().map(
           root -> root.withChildren(
                   this.select(new EShopRolePermission().withParentId(root.getId()).withDelFlag((byte)0))
           )
        ).collect(Collectors.toList());
    }

    //增 暗账用
    @CacheEvict(cacheNames = CacheConstant.CACHE_ROLE_PERMISSION_BY_ROLE_ID, allEntries = true) //删除所有用户的缓存
    @CachePut(cacheNames = CacheConstant.CACHE_ROLE_PERMISSION_BY_ID, key = "#p0.id")
    public EShopRolePermission insertRolePermission(EShopRolePermission Permission) {
        this.insert(Permission.withDelFlag((byte)0));//表示有效
        return Permission;
    }

    //删除
    @CacheEvict(cacheNames = CacheConstant.CACHE_ROLE_PERMISSION_BY_ROLE_ID, allEntries = true) //删除所有用户的缓存
    @CachePut(cacheNames = CacheConstant.CACHE_ROLE_PERMISSION_BY_ID, key = "#p0")
    public EShopRolePermission deleteRolePermission(int PermissionId) {
        EShopRolePermission Permission = this.selectRolePermissionById(PermissionId);
        Permission.setDelFlag((byte)1); //1表示删除
        this.updateNotNull(Permission);
        return Permission;
    }


    //改
    @CacheEvict(cacheNames = CacheConstant.CACHE_ROLE_PERMISSION_BY_ROLE_ID, allEntries = true) //删除所有用户的缓存
    @CachePut(cacheNames = CacheConstant.CACHE_ROLE_PERMISSION_BY_ID, key = "#p0.id")
    public EShopRolePermission updateRolePermission(EShopRolePermission Permission) {
        this.updateNotNull(Permission);
        return Permission;
    }






//    private EShopRolePermission addChild(EShopRolePermission root, EShopRolePermission child) {
////        root.getChildren()
//    }


}
