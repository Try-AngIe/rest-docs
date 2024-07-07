package com.example.test.test.domain.product.controller;

import com.example.test.test.domain.product.dto.TProductItemInfo;
import com.example.test.test.domain.product.dto.TProductItemList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendor/products")
public class TProductController {

    @GetMapping
    public TProductItemList getProducts(@RequestParam int page, @RequestParam int size) {
        // 테스트용 더미 데이터 생성 (실제 데이터는 여기서 DB 등에서 가져와야 함)
        List<TProductItemInfo> dummyData = createDummyData(page, size);

        // Pagination 정보 생성 (실제 로직에 따라 계산 필요)
        int totalPage = 150;
        int totalCount = 1496;

        // Response 객체 생성
        TProductItemList response = new TProductItemList();
        response.setPage(page);
        response.setSize(size);
        response.setTotalPage(totalPage);
        response.setTotalCount(totalCount);
        response.setData(dummyData);

        return response;
    }

    // 테스트용 더미 데이터 생성 메서드 (실제 데이터베이스 연동으로 대체해야 함)
    private List<TProductItemInfo> createDummyData(int page, int size) {
        // 여기서는 간단하게 더미 데이터 생성 예시를 보여줍니다.
        List<TProductItemInfo> dummyData = List.of(
                new TProductItemInfo("상품 1", 10.0, 1, "2024-01-01", "Note 1"),
                new TProductItemInfo("상품 2222222", 20.0, 2, "2024-01-02", "Note 2"),
                new TProductItemInfo("상품 3", 30.0, 3, "2024-01-02", "Note 3")
                // 필요한 만큼 데이터 추가
        );
        return dummyData;
    }
}
