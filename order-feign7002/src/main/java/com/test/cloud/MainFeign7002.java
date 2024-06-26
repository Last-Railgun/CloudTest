package com.test.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication()
@MapperScan("com.test.cloud.mapper")
@EnableFeignClients
@EnableDiscoveryClient
public class MainFeign7002 {
    public static void main(String[] args) {
        SpringApplication.run(MainFeign7002.class, args);
    }
}