package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
/**
 * @author liuzunyu
 * @version 1.0.0
 * @date 2019/9/5
 * @description 测试demo
 */
public class BookApplication {
    /**
     * 启动类
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
