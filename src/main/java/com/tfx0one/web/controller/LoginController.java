package com.tfx0one.web.controller;

import com.tfx0one.common.util.UserAccountUtils;
import com.tfx0one.web.model.UserAccount;
import com.tfx0one.web.service.UserAccountService;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class LoginController {


    @Resource
    UserAccountUtils userAccountUtils;

    @Resource
    private UserAccountService userAccountService;

//    @RequestMapping(value="/index", method = RequestMethod.GET)
//    public String index() {
//        return "main";
//    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginPage() {
        System.out.println("loginPage() GET");
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestParam Integer userId) {
        System.out.println("login() POST");
        UserAccount userAccount = userAccountService.selectByPrimaryKey(userId);
        userAccountUtils.cacheLoginUser(userAccount);
        return "main";
    }
}
