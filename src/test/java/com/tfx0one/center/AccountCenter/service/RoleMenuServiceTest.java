package com.tfx0one.center.AccountCenter.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMenuServiceTest {

    @Resource
    private RoleMenuService roleMenuService;
    @Test
    public void selectRoleMenuByRoleId() {
        roleMenuService.selectRoleMenuByRoleId(1).forEach(System.out::println);
        roleMenuService.selectAllRoleMenu().forEach(System.out::println);
    }
}