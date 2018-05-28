package com.tfx0one.web.controller;

import com.tfx0one.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index() {
        User user = new User();
        user.setName("aaaa");
        user.setPassword("bbbb");
        user.setCreateTime(new Date());
        userService.save(user);
        return "main";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginPage() {
        System.out.println("loginPage()");
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login() {
        System.out.println("login()");
        return "main";
    }
}
