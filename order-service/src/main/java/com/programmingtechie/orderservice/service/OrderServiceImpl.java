package com.programmingtechie.orderservice.service;

import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.model.OrderLineItem;
import com.programmingtechie.orderservice.model.dto.InventoryDtoResponse;
import com.programmingtechie.orderservice.model.dto.OrderRequestDto;
import com.programmingtechie.orderservice.model.dto.mapper.OrderLineItemMapper;
import com.programmingtechie.orderservice.model.dto.mapper.OrderMapper;
import com.programmingtechie.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderLineItemMapper orderLineItemMapper;
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public void placeOrder(OrderRequestDto requestDto) throws IllegalAccessException {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItemList = requestDto.getOrderLineItemRequestDtoList()
                .stream()
                .map(orderLineItemMapper::toModel)
                .collect(Collectors.toList());
        order.setOrderLineItemList(orderLineItemList);

        List<String> skuCodes = order.getOrderLineItemList()
                .stream()
                .map(OrderLineItem::getSkuCode)
                .toList();

        InventoryDtoResponse[] inventoryDtoResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventories",
                        uriBuilder -> uriBuilder.queryParam("skuCode",
                                skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryDtoResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryDtoResponses)
                .allMatch(InventoryDtoResponse::isInStock);

        if (allProductsInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalAccessException("Product is not in stock");
        }
    }
}
