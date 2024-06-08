package com.ms.orderservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailDTO {

    private Integer quantity;
    private BigDecimal price;
    private Long productId;

}