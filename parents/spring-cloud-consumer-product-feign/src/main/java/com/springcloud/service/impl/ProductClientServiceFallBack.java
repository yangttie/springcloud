package com.springcloud.service.impl;

import com.springcloud.entities.Product;
import com.springcloud.service.ProductClientService;
import org.springframework.stereotype.Component;

import java.util.List;
/***
 * hystrix 熔断回调函数
 * @ClassName ProductClientServiceFallBack
 * @Description
 * @author YangLi
 * @date 2019/6/26 11:43
 */
@Component
public class ProductClientServiceFallBack implements ProductClientService {
    @Override
    public boolean add(Product product) {
        return false;
    }

    @Override
    public Product get(Long id) {
        return new Product(id, "id="+ id + "无数据--feign&hystrix", "无有效数据库");
    }

    @Override
    public List<Product> list() {
        return null;
    }
}
