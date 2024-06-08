package com.ms.orderservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {

    private String customerName;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
    private List<OrderDetailDTO> orderDetails;

}