package com.ms.productservice.service;

import com.ms.productservice.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);
}
