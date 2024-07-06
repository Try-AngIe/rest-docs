package com.example.test.controller;

import com.example.test.dto.ProductsResponseDto;
import com.example.test.entity.Products;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vendor/products")
public class ProductsController {

    private List<Products> productsList = Arrays.asList(
            Products.builder().name("제목1").price(1000.0).contractCount(5).createdAt("2024-07-07").notes("내용1").build(),
            Products.builder().name("제목2").price(2000.0).contractCount(10).createdAt("2024-07-08").notes("내용2").build(),
            Products.builder().name("제목3").price(3000.0).contractCount(15).createdAt("2024-07-09").notes("내용3").build()
    );

    @GetMapping
    public ResponseEntity<Map<String, Object>> getProducts(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "2") int size) {
        int start = page * size;
        int end = Math.min((page + 1) * size, productsList.size());

        if (start > productsList.size()) {
            return ResponseEntity.ok(Map.of(
                    "page", page,
                    "size", size,
                    "totalPage", (productsList.size() + size - 1) / size,
                    "totalCount", productsList.size(),
                    "data", Collections.emptyList()
            ));
        }

        List<ProductsResponseDto> productsResponseList = this.productsList.subList(start, end).stream()
                .map(ProductsResponseDto::fromEntity)
                .collect(Collectors.toList());

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("page", page);
        response.put("size", size);
        response.put("totalPage", (this.productsList.size() + size - 1) / size);
        response.put("totalCount", this.productsList.size());
        response.put("data", productsResponseList);

        return ResponseEntity.ok(response);
    }
}
