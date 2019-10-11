package com.jd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzunyu
 * @version 1.0.0
 * @date 2019/9/5
 * @description 版本信息
 */
@RestController
// 配置 配置服务中心自动刷新
@RefreshScope
public class ConfigClientController {

    /**
     * 应用版本
     */
    @Value("${test.version}")
    private String version;

    /**
     * 应用名称
     */
    @Value("${spring.application.name}")
    private String name;

    /**
     * 应用端口
     */
    @Value("${server.port}")
    private String port;

    /**
     * 获取应用基本信息
     * @return 返回版本信息
     */
    @GetMapping("/getVersion")
    public String version(){
        return "ApplicationName:["+this.name+"] "+" ServerPort:["+this.port+"] Current version: [" + this.version + "]" ;
    }

}
