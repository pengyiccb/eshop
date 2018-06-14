package com.tfx0one.common.qiniu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wynn on 2018/6/13.
 */
@Component
public class QiniuUpload {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.path}")
    private String path;

    public String getAccessKey(){return this.accessKey;};

    public String getSecretKey(){return this.secretKey;};

    public String getBucket(){return this.bucket;};

    public String getPath(){return this.path;};

}
