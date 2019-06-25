package com.springcloud.service;


import com.springcloud.entities.Product;

import java.util.List;


public interface ProductService {

    boolean add(Product product);

    Product get(Long id);

    List<Product> list();

}
