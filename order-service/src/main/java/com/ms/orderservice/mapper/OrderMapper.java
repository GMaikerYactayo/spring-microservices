package com.ms.orderservice.mapper;

import com.ms.orderservice.dto.OrderDTO;
import com.ms.orderservice.model.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO mapToDTO(Order order);

    Order mapToEntity(OrderDTO orderDTO);

    List<OrderDTO> mapListToDTO(List<Order> orders);

}
