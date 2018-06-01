package com.tfx0one.web.controller;

import com.tfx0one.common.util.AjaxObject;
import com.tfx0one.web.model.DemoModel;
import com.tfx0one.web.model.UserAccount;
import com.tfx0one.web.service.DemoService;
import com.tfx0one.web.service.UserAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 2fx0one on 28/5/2018.
 */

@RestController
public class DemoController {
    @Resource
    private DemoService demoService;

    @ApiOperation(value = "测试用的", notes = "测试接口")
    @RequestMapping(value="/demo/list", method = RequestMethod.GET)
    public AjaxObject list() {

        List<DemoModel> l =  demoService.selectAll();

        return AjaxObject.ok().data(l);
    }

    @RequestMapping(value="/demo/post", method = RequestMethod.POST)
    public AjaxObject post(@RequestBody DemoModel demo) {
        return AjaxObject.ok().data(demo);
    }





}
