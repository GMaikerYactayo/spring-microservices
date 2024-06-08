package com.ms.orderservice.response;

import com.ms.orderservice.dto.ProductDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailResponse {

    private Integer quantity;
    private BigDecimal price;
    private ProductDTO product;

}