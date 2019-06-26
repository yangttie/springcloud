package com.springcloud.service;

import com.springcloud.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiYang
 * @version 1.0
 * @date 2019/6/26 0:18
 */
@FeignClient(value = "spring-cloud-product") //指定调用的微服务名称:  http://spring-cloud-product/product/add

public interface ProductClientService {

    @PostMapping("/product/add")
    boolean add(@RequestBody Product product);

    @GetMapping("/product/get/{id}")
    Product get(@PathVariable("id") Long id);

    @GetMapping("/product/list")
    List<Product> list();

}
