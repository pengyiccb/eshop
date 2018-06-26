package com.tfx0one.center.AccountCenter.mapper;

import com.tfx0one.center.AccountCenter.model.EShopRole;
import com.tfx0one.common.util.MyMapper;

import java.util.List;

public interface EShopRoleMapper extends MyMapper<EShopRole> {

    List<EShopRole> selectUserRoleByPermissionId(int permissionId);
}