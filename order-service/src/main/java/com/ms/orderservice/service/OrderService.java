package com.ms.orderservice.service;

import com.ms.orderservice.model.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);
    List<Order> findAll();
    Order findById(Long id);

}
