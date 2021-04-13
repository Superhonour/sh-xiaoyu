package com.sh.xiaoyu.admin.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan({"com.sh.xiaoyu.admin.biz.mapper"})
@EnableFeignClients(basePackages = "com.sh.xiaoyu.admin.api.feign.client")
@ComponentScan(basePackages = {"com.sh.xiaoyu"})
// @EnableSwagger2Doc
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
