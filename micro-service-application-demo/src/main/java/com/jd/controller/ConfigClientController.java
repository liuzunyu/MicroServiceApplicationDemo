package com.jd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzunyu
 * @version 1.0.0
 * @date 2019/9/5
 * @description
 */
@RestController
// 配置 配置服务中心自动刷新
@RefreshScope
public class ConfigClientController {

    @Value("${test.version}")
    private String version;

    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getVersion")
    public String version(){
        return "ApplicationName:["+this.name+"] "+" ServerPort:["+this.port+"] Current version: [" + this.version + "]" ;
    }

}
