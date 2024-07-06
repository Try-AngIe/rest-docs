package com.example.test.dto;

import com.example.test.entity.Products;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductsResponseDto {

    private String name;
    private double price;
    private int contractCount;
    private String createdAt;
    private String notes;

    public static ProductsResponseDto fromEntity(Products products) {
        return ProductsResponseDto.builder()
                .name(products.getName())
                .contractCount(products.getContractCount())
                .price(products.getPrice())
                .createdAt(products.getCreatedAt())
                .notes(products.getNotes())
                .build();
    }

}
