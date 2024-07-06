package com.example.test.entity;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Products {

    private String name;
    private double price;
    private int contractCount;
    private String createdAt;
    private String notes;

}
