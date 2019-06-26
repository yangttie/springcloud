package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@MapperScan("com.springcloud.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix //开启hystrix的熔断机制
public class ProductProvider_hystrix_8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_hystrix_8001.class, args);
    }

}
