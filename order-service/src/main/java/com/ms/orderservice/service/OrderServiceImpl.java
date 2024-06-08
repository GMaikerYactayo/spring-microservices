package com.ms.orderservice.service;

import com.ms.orderservice.client.ProductClient;
import com.ms.orderservice.dto.*;
import com.ms.orderservice.mapper.OrderMapper;
import com.ms.orderservice.model.Order;
import com.ms.orderservice.repository.OrderRepository;
import com.ms.orderservice.response.OrderDetailResponse;
import com.ms.orderservice.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream()
                .map(order -> {
                    OrderResponse orderResponse = new OrderResponse();
                    orderResponse.setTotalAmount(order.getTotalAmount());
                    orderResponse.setCustomerName(order.getCustomerName());
                    orderResponse.setCreatedAt(order.getCreatedAt());
                    orderResponse.setOrderDetails(order.getOrderDetails().stream()
                            .map(orderDetail -> {
                                OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
                                orderDetailResponse.setQuantity(orderDetail.getQuantity());
                                orderDetailResponse.setPrice(orderDetail.getPrice());
                                Long productId = orderDetail.getProductId();
                                ProductDTO product = productClient.findById(productId);
                                orderDetailResponse.setProduct(product);
                                return orderDetailResponse;
                            }).collect(Collectors.toList())
                    );
                    return orderResponse;
                }).collect(Collectors.toList());
    }

    @Override
    public OrderResponse findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order with ID " + id + " not found"));

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setTotalAmount(order.getTotalAmount());
        orderResponse.setCustomerName(order.getCustomerName());
        orderResponse.setCreatedAt(order.getCreatedAt());
        orderResponse.setOrderDetails(order.getOrderDetails().stream()
                .map(orderDetail -> {
                    OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
                    orderDetailResponse.setQuantity(orderDetail.getQuantity());
                    orderDetailResponse.setPrice(orderDetail.getPrice());
                    Long productId = orderDetail.getProductId();
                    ProductDTO productDTO = productClient.findById(productId);
                    orderDetailResponse.setProduct(productDTO);
                    return orderDetailResponse;
                }).collect(Collectors.toList())
        );
        return orderResponse;
    }

    @Override
    public OrderDTO save(OrderDTO order) {
        for (OrderDetailDTO detail: order.getOrderDetails()) {
            boolean productExists = productClient.existsProductById(detail.getProductId());
            if (!productExists) {
                throw new RuntimeException("Product with ID " + detail.getProductId() + " does not exist.");
            }
        }
        Order mappedToEntity = orderMapper.mapToEntity(order);
        Order savedOrder = orderRepository.save(Objects.requireNonNull(mappedToEntity));
        return orderMapper.mapToDTO(savedOrder);
    }

}
