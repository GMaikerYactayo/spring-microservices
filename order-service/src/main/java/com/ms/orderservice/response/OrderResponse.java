package com.ms.orderservice.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {

    private String customerName;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
    private List<OrderDetailResponse> orderDetails;

}
