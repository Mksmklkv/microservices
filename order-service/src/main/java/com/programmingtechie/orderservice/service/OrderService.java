package com.programmingtechie.orderservice.service;

import com.programmingtechie.orderservice.model.dto.OrderRequestDto;

public interface OrderService {
    void placeOrder(OrderRequestDto requestDto)
            throws IllegalAccessException;
}
