package com.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.springcloud.entities.Product;
import com.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    //如果方法出现了异常则会调用 fallbackMethod
    @HystrixCommand(fallbackMethod = "getFallback")
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        Product p = productService.get(id);
        if(p == null){
            throw new RuntimeException("ID="+id+"无效");
        }
        return p;
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }


    public Product getFallback(@PathVariable("id") Long id) {
        return new Product(id, "ID=" + id +"无效----@HystrixCommand",
                "无法找到对应数据库");
    }
}
