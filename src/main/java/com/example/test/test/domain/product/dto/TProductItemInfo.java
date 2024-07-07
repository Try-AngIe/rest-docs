package com.example.test.test.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
public class TProductItemInfo {
    private String name;
    private double price;
    private int contractCount;
    private String createdAt;
    private String notes;
}
