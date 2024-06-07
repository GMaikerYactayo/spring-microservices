package com.ms.orderservice.service;

import com.ms.orderservice.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();
    Order findById(Long id);
    Order save(Order order);

}
