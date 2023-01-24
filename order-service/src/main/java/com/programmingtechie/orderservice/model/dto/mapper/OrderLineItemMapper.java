package com.programmingtechie.orderservice.model.dto.mapper;

import com.programmingtechie.orderservice.model.OrderLineItem;
import com.programmingtechie.orderservice.model.dto.OrderLineItemRequestDto;
import com.programmingtechie.orderservice.model.dto.OrderLineItemResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderLineItemMapper implements Mapper<OrderLineItem,
        OrderLineItemRequestDto, OrderLineItemResponseDto> {
    @Override
    public OrderLineItem toModel(OrderLineItemRequestDto orderLineItemRequestDto) {
        return OrderLineItem.builder()
                .skuCode(orderLineItemRequestDto.getSkuCode())
                .price(orderLineItemRequestDto.getPrice())
                .quantity(orderLineItemRequestDto.getQuantity())
                .build();
    }

    @Override
    public OrderLineItemResponseDto toDto(OrderLineItem orderLineItem) {
        return null;
    }
}
