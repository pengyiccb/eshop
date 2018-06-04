package com.tfx0one.web.controller;

import com.tfx0one.common.util.JSONResult;
import com.tfx0one.web.model.Demo;
import com.tfx0one.web.service.DemoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 2fx0one on 28/5/2018.
 */

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
public class DemoController {
    @Resource
    private DemoService demoService;

    @ApiOperation(value = "测试用的", notes = "测试接口")
    @RequestMapping(value="/demo/list", method = RequestMethod.GET)
    public JSONResult list() {

        List<Demo> l =  demoService.selectAll();

        return JSONResult.ok().data(l);
    }

    @RequestMapping(value="/demo/post", method = RequestMethod.POST)
    public JSONResult post(@RequestBody Demo demo) {
        return JSONResult.ok().data(demo);
    }





}
