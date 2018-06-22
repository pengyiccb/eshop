package com.tfx0one.center.AccountCenter.mapper;

import com.tfx0one.center.AccountCenter.model.EShopRoleMenu;
import com.tfx0one.common.util.MyMapper;

import java.util.List;

public interface EShopRoleMenuMapper extends MyMapper<EShopRoleMenu> {
    List<EShopRoleMenu> selectRoleMenuByRoleId(int roleId);
}