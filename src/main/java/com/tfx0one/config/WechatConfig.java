package com.tfx0one.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by 2fx0one on 28/5/2018.
 */
@Configuration
@PropertySource("classpath:wechat.properties")
@ConfigurationProperties(prefix = "wxapp")
public class WechatConfig {
    private String appId;

    private String secret;

    private String grantType;

    private String jscode2session;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getJscode2session() {
        return jscode2session;
    }

    public void setJscode2session(String jscode2session) {
        this.jscode2session = jscode2session;
    }
}
