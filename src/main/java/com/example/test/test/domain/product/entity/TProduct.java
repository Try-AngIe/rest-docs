package com.example.test.test.domain.product.entity;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TProduct {

    private String name;
    private double price;
    private int contractCount;
    private String createdAt;
    private String notes;

}
