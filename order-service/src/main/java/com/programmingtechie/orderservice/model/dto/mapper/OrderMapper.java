package com.programmingtechie.orderservice.model.dto.mapper;

import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.model.dto.OrderRequestDto;
import com.programmingtechie.orderservice.model.dto.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<Order, OrderRequestDto, OrderResponseDto> {

    @Override
    public Order toModel(OrderRequestDto requestDto) {
        return null;
    }

    @Override
    public OrderResponseDto toDto(Order order) {
        return null;
    }
}
