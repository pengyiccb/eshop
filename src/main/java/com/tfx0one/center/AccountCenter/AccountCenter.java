package com.tfx0one.center.AccountCenter;

import com.tfx0one.center.AccountCenter.model.EShopRolePermission;
import com.tfx0one.center.AccountCenter.model.EShopUser;
import com.tfx0one.center.AccountCenter.service.RolePermissionService;
import com.tfx0one.center.AccountCenter.service.RoleService;
import com.tfx0one.center.AccountCenter.service.UserService;
import com.tfx0one.common.constant.UserConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2fx0one on 2018/6/16.
 */
@Component
public class AccountCenter {
    private final Logger logger = LoggerFactory.getLogger(AccountCenter.class);

//    @Resource
//    //app内的缓存
//    private CacheUtils cacheUtils;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private RolePermissionService rolePermissionService;

//    public EShopUser refreshLoginUser(String username) {
//        EShopUser EShopUser = userService.selectOne(new EShopUser().withUsername(username));
//        this.putCacheLoginUser(EShopUser, EShopUser.getUsername());
//        return EShopUser;
//    }

//    //放入缓存 用户信息
//    private void putCacheLoginUser(EShopUser EShopUser, String username) {
//        cacheUtils.put(CacheConstant.CACHE_USER_BY_USERNAME, username, EShopUser);
//    }

    //获取缓存 登录的用户信息
    // ！！！不要在 security的 JwtAuthenticationTokenFilter 拦截器中调用。因为用户信息绑定在 SecurityContextHolder上。
    public EShopUser getCacheLoginUser() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            throw new RuntimeException("SecurityContextHolder.getContext().getAuthentication() == null");
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("getCacheLoginUser() " + userDetails.getUsername());
        return getCacheLoginUserByUsername(userDetails.getUsername());
    }

    private EShopUser getCacheLoginUserByUsername(String username) {
        return userService.selectByUsername(username);
//        return StringUtils.isEmpty(username) ? null : cacheUtils.get(CacheConstant.CACHE_USER_BY_USERNAME, username);
    }

    //检查数据库 role 表是否配置正确
    public void checkDatabaseRole() {
//        roleService.checkDatabaseRole();
        //=====1 数据库中 必须包含的三个基本管理员。 id固定=====
//        List<EShopRole> roleList = new ArrayList<>();
//        roleList.add(new EShopRole()
//                .withId(UserConstant.USER_ROLE_ID_ADMIN)
//                .withPermissionStr(UserConstant.USER_ROLE_PERMISSION_ADMIN)
//                .withTitle(UserConstant.USER_ROLE_TITLE_ADMIN).withDelFlag((byte)0));
//
//        roleList.add(new EShopRole()
//                .withId(UserConstant.USER_ROLE_ID_VENDOR)
//                .withPermissionStr(UserConstant.USER_ROLE_PERMISSION_VENDOR)
//                .withTitle(UserConstant.USER_ROLE_TITLE_VENDOR).withDelFlag((byte)0));
//
//        roleList.add(new EShopRole()
//                .withId(UserConstant.USER_ROLE_ID_CONSUMER)
//                .withPermissionStr(UserConstant.USER_ROLE_PERMISSION_CONSUMER)
//                .withTitle(UserConstant.USER_ROLE_TITLE_CONSUMER).withDelFlag((byte)0));
//
//        roleList.stream().filter(role -> roleService.selectOne(role) == null).forEach(roleService::insert);

//        userService.checkDatabaseAdmin();

        //====2 检查超级管理员， 没有就创建一个====
        //数据库，必须包含超级管理员。 id固定为 1
        EShopUser user = new EShopUser()
                .withId(1)
                .withUsername("admin")
                .withStatus(UserConstant.USER_STATUS_NORMAL)
                .withRoleId(UserConstant.USER_ROLE_ID_ADMIN);
        if (userService.selectOne(user) == null) {
            userService.insertUser(user.withPassword(new BCryptPasswordEncoder().encode("123456")));
        }

        //====3 检查数据库菜单 必须包含的菜单 ====
//        1系统管理:
//          2菜单配置
//        3用户管理
//            4角色配置
//            5用户配置

        List<EShopRolePermission> menuList = new ArrayList<>();

        EShopRolePermission a = new EShopRolePermission().withId(1).withParentId(0).withTitle("系统管理").withIcon("icon").withDescription("desc").withUrl("url").withDelFlag((byte)0);
        EShopRolePermission a1 = new EShopRolePermission().withId(2).withParentId(1).withTitle("菜单配置").withIcon("icon").withDescription("desc").withUrl("url").withDelFlag((byte)0);

        EShopRolePermission b = new EShopRolePermission().withId(3).withParentId(0).withTitle("用户管理").withIcon("icon").withDescription("desc").withUrl("url").withDelFlag((byte)0);
        EShopRolePermission b1 = new EShopRolePermission().withId(4).withParentId(3).withTitle("角色配置").withIcon("icon").withDescription("desc").withUrl("url").withDelFlag((byte)0);
        EShopRolePermission b2 = new EShopRolePermission().withId(5).withParentId(3).withTitle("用户配置").withIcon("icon").withDescription("desc").withUrl("url").withDelFlag((byte)0);
        menuList.add(a);
        menuList.add(a1);

        menuList.add(b);
        menuList.add(b1);
        menuList.add(b2);
        menuList.stream().filter(menu -> rolePermissionService.selectOne(menu) == null).forEach(rolePermissionService::insert);
    }

}
