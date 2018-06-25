package com.tfx0one.center.AccountCenter.mapper;

import com.tfx0one.center.AccountCenter.model.EShopRolePermission;
import com.tfx0one.common.util.MyMapper;

import java.util.List;

public interface EShopRolePermissionMapper extends MyMapper<EShopRolePermission> {
    List<EShopRolePermission> selectRolePermissionByRoleId(int roleId);

    List<EShopRolePermission> selectAllActiveURLRolePermission();
}