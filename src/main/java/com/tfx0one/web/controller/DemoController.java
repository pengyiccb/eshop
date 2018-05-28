package com.tfx0one.web.controller;

import com.tfx0one.common.util.AjaxObject;
import com.tfx0one.web.model.UserAccount;
import com.tfx0one.web.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 2fx0one on 28/5/2018.
 */

@RestController
public class DemoController {
    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(value="/demo/list", method = RequestMethod.GET)
    public AjaxObject list() {

        List<UserAccount> l =  userAccountService.select(null);

        return AjaxObject.ok().data(l);
    }

    @RequestMapping(value="/demo/add", method = RequestMethod.GET)
    public AjaxObject add() {

        List<UserAccount> l =  userAccountService.select(null);

        return AjaxObject.ok().data(l);
    }



}
