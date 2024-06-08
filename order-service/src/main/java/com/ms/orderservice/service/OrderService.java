package com.ms.orderservice.service;

import com.ms.orderservice.dto.OrderDTO;
import com.ms.orderservice.response.OrderResponse;

import java.util.List;

public interface OrderService {

    List<OrderResponse> findAll();
    OrderResponse findById(Long id);
    OrderDTO save(OrderDTO order);

}
