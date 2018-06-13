package com.tfx0one.web.mapper;

import com.tfx0one.common.util.MyMapper;
import com.tfx0one.web.model.UserAddr;

public interface UserAddrMapper extends MyMapper<UserAddr> {

    int add(UserAddr addr);
}