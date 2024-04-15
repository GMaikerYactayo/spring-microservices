package com.ms.productservice.service;

import com.ms.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    Product findById(Long id);
}
