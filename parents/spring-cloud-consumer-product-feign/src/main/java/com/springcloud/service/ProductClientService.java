package com.springcloud.service;

import com.springcloud.entities.Product;
import com.springcloud.service.impl.ProductClientServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author LiYang
 * @version 1.0
 * @date 2019/6/26 0:18
 */
//指定调用的微服务名称:  http://spring-cloud-product/product/add
@FeignClient(value = "spring-cloud-product", fallback = ProductClientServiceFallBack.class)
public interface ProductClientService {

    @PostMapping("/product/add")
    boolean add(@RequestBody Product product);

    @GetMapping("/product/get/{id}")
    Product get(@PathVariable("id") Long id);

    @GetMapping("/product/list")
    List<Product> list();

}
