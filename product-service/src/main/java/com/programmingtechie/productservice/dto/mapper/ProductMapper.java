package com.programmingtechie.productservice.dto.mapper;

import com.programmingtechie.productservice.dto.ProductRequestDto;
import com.programmingtechie.productservice.dto.ProductResponseDto;
import com.programmingtechie.productservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<Product,
        ProductRequestDto, ProductResponseDto> {

    @Override
    public Product toModel(ProductRequestDto productRequestDto) {
        return Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice()).build();
    }

    @Override
    public ProductResponseDto toDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
