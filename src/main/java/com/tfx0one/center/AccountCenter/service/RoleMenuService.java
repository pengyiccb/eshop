package com.tfx0one.center.AccountCenter.service;

import com.tfx0one.center.AccountCenter.mapper.EShopRoleMenuMapper;
import com.tfx0one.center.AccountCenter.model.EShopRoleMenu;
import com.tfx0one.common.cache.CacheUtils;
import com.tfx0one.common.constant.CacheConstant;
import com.tfx0one.common.util.BaseService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/22.
 */
@Service
public class RoleMenuService extends BaseService<EShopRoleMenu> {

    @Resource
    private EShopRoleMenuMapper eShopRoleMenuMapper;

    @Resource
    private CacheUtils cacheUtils;


    //获取的菜单。
    @Cacheable(cacheNames = CacheConstant.CACHE_ROLE_MENU_BY_ID, key = "#p0")
    public EShopRoleMenu selectRoleMenuById(int meunId) {
        //保证类内部调用也可以启动缓存
        EShopRoleMenu menu = cacheUtils.get(CacheConstant.CACHE_ROLE_MENU_BY_ID, String.valueOf(meunId));
        if (menu == null) {
            menu = this.selectByPrimaryKey(meunId);
            cacheUtils.put(CacheConstant.CACHE_ROLE_MENU_BY_ID, String.valueOf(meunId), menu);
        }
        return menu;
    }

    //整个菜单树 超级管理员获取 只支持两级
    public List<EShopRoleMenu> selectAllRoleMenu(){
        return this.select(new EShopRoleMenu().withParentId(0)).parallelStream().map(
           root -> root.withChildren(
                   this.select(new EShopRoleMenu().withParentId(root.getId()))
           )
        ).collect(Collectors.toList());
    }

    //增
    @CacheEvict(cacheNames = CacheConstant.CACHE_ROLE_MENU_BY_ROLE_ID, allEntries = true) //删除所有用户的缓存
    @CachePut(cacheNames = CacheConstant.CACHE_ROLE_MENU_BY_ID, key = "#p0.id")
    public EShopRoleMenu insertRoleMenu(EShopRoleMenu menu) {
        this.insert(menu);
        return menu;
    }

    //删除
    @CacheEvict(cacheNames = CacheConstant.CACHE_ROLE_MENU_BY_ROLE_ID, allEntries = true) //删除所有用户的缓存
    @CachePut(cacheNames = CacheConstant.CACHE_ROLE_MENU_BY_ID, key = "#p0")
    public EShopRoleMenu deleteRoleMenu(int menuId) {
        EShopRoleMenu menu = this.selectRoleMenuById(menuId);
        menu.setDelFlag((byte)1); //1表示删除
        this.updateNotNull(menu);
        return menu;
    }


    //改
    @CacheEvict(cacheNames = CacheConstant.CACHE_ROLE_MENU_BY_ROLE_ID, allEntries = true) //删除所有用户的缓存
    @CachePut(cacheNames = CacheConstant.CACHE_ROLE_MENU_BY_ID, key = "#p0.id")
    public EShopRoleMenu updateRoleMenu(EShopRoleMenu menu) {
        this.updateNotNull(menu);
        return menu;
    }


    //用户缓存菜单树
    @Cacheable(cacheNames = CacheConstant.CACHE_ROLE_MENU_BY_ROLE_ID, key = "#p0")
    public List<EShopRoleMenu> selectRoleMenuByRoleId(int roleId) {
        List<EShopRoleMenu> menus = eShopRoleMenuMapper.selectRoleMenuByRoleId(roleId);

        //转出map
//        Map<Integer, EShopRoleMenu> map = menus.stream().collect(Collectors.toMap(EShopRoleMenu::getId, e -> e));

//        Map<Integer, EShopRoleMenu> tree = new HashMap<>();

        //由于只有两级 故而先构建根节点 再遍历子节点
        return menus.stream()
                .filter(e -> e.getParentId()==0)
                .map(root -> //遍历根节点 第一级
                    root.withChildren(
                        menus.stream() //找到所有是这个父节点的子节点 第二级
                                .filter(child -> child.getParentId().equals(root.getId())
                        ).collect(Collectors.toList())
                    )
                ).collect(Collectors.toList());

//        //再遍历子节点
//        menus.stream()
//                .filter(e-> e.getParentId()!=0)
//                .forEach(e -> {
//                    if (tree.containsKey(e.getParentId()))
//                });
//
//        menus.forEach(menu -> {
//            if (!menuTree.containsKey(menu.getParentId())) {//不存在就创建
//                menuTree.put(menu.getParentId(), new ArrayList<>());
//            }
//            menuTree.get(menu.getParentId()).add(menu);
//        });
//
//        return null;

    }



//    private EShopRoleMenu addChild(EShopRoleMenu root, EShopRoleMenu child) {
////        root.getChildren()
//    }


}
