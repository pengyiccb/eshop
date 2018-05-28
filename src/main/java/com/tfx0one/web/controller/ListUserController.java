package com.tfx0one.web.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListUserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "list", notes="list notes")
    @ApiImplicitParam(name = "pname", value = "pv", required = false, dataType = "User")
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<User> index() {
        List<User> list = userService.select(null);
//        return AjaxObject.ok().put("list", list);
        return list;
    }


}
