package com.programmingtechie.productservice.service;

import com.programmingtechie.productservice.dto.ProductRequestDto;
import com.programmingtechie.productservice.dto.ProductResponseDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductService {
    void createProduct(ProductRequestDto requestDto);

    List<ProductResponseDto> getAllProducts();
}
