package com.tfx0one.web.service;

import com.tfx0one.center.AccountCenter.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/*
 * Create by 2fx0one on 2/6/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void test1() {
        System.out.println("");
    }

}