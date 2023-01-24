package com.programmingtechie.inventoryservice.service;

import com.programmingtechie.inventoryservice.model.dto.InventoryDtoResponse;
import com.programmingtechie.inventoryservice.model.dto.Mapper.InventoryMapper;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<InventoryDtoResponse> isInStock(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes)
                .stream()
                .map(inventoryMapper::toDto)
                .toList();
    }
}
