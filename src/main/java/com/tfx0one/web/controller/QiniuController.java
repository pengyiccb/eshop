package com.tfx0one.web.controller;

import com.tfx0one.common.qiniu.QiniuUploadService;
import com.tfx0one.common.util.JSONResult;
import com.tfx0one.common.util.RandomNameUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by wynn on 2018/6/13.
 */

@RestController
public class QiniuController {
    @Resource
    private QiniuUploadService qiniuUploadService;

    @Resource
    private RandomNameUtil randomNameUtil;

    @ApiOperation(value = "上传图片", notes = "图片文件流MultipartFile")
    @RequestMapping(value = "/api/v1/qiniu/uploadfile", method = RequestMethod.POST)
    public JSONResult uploadFile(@RequestBody MultipartFile multipartFile)  throws IOException {

        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
        String urlstr =  qiniuUploadService.uploadQNImg(inputStream, randomNameUtil.getRandomName());
        if (urlstr.equals("")){
            return JSONResult.error(500, "上传文件失败");
        }
        return JSONResult.ok().data(urlstr);
    }
}
