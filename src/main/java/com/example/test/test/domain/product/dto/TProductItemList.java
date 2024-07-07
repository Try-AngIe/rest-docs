package com.example.test.test.domain.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TProductItemList {
    private int page;
    private int size;
    private int totalPage;
    private int totalCount;
    private List<TProductItemInfo> data;
}
