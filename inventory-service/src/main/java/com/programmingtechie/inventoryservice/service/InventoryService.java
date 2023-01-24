package com.programmingtechie.inventoryservice.service;

import com.programmingtechie.inventoryservice.model.dto.InventoryDtoResponse;
import java.util.List;

public interface InventoryService {
    public List<InventoryDtoResponse> isInStock(List<String> skuCodes);
}
