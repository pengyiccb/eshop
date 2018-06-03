package com.tfx0one.web.service;

import com.tfx0one.web.model.UserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;


/*
 * Create by 2fx0one on 2/6/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAccountServiceTest {

    @Resource
    private UserAccountService userAccountService;

    @Test
    public void test1() {
        UserAccount cacheUserAccount = userAccountService.selectOne(new UserAccount().withOpenId(""));
        System.out.println(cacheUserAccount);
    }

}