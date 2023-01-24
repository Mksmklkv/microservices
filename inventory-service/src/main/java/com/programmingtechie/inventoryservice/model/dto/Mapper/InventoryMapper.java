package com.programmingtechie.inventoryservice.model.dto.Mapper;

import com.programmingtechie.inventoryservice.model.Inventory;
import com.programmingtechie.inventoryservice.model.dto.InventoryDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    public InventoryDtoResponse toDto(Inventory inventory) {
        return InventoryDtoResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }
}
