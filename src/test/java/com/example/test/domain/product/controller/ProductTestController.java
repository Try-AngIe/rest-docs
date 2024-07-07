package com.example.test.domain.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.headers.HeaderDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.modifyUris;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

@ExtendWith({RestDocumentationExtension.class})
@AutoConfigureMockMvc
@SpringBootTest
class ProductTestController {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext,
               RestDocumentationContextProvider restDocumentationContextProvider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .apply(documentationConfiguration(restDocumentationContextProvider)
                        .operationPreprocessors()
                        .withRequestDefaults(modifyUris().host("localhost").removePort(), prettyPrint())
                        .withResponseDefaults(modifyUris().host("localhost").removePort(), prettyPrint()))
                .build();
    }

    @Test
    void getProducts() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/vendor/products")
                        .param("page", "1")
                        .param("size", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andDo(document("getProducts",
                        HeaderDocumentation.requestHeaders(
                                HeaderDocumentation.headerWithName(HttpHeaders.ACCEPT).description("Accept 헤더")
                        ),
                        HeaderDocumentation.responseHeaders(
                                HeaderDocumentation.headerWithName(HttpHeaders.CONTENT_TYPE).description("Content-Type 헤더")
                        ),
                        PayloadDocumentation.responseFields(
                                PayloadDocumentation.fieldWithPath("page").description("현재 페이지 번호"),
                                PayloadDocumentation.fieldWithPath("size").description("페이지당 항목 수"),
                                PayloadDocumentation.fieldWithPath("totalPage").description("총 페이지 수"),
                                PayloadDocumentation.fieldWithPath("totalCount").description("총 제품 수"),
                                PayloadDocumentation.fieldWithPath("data[].name").description("제품 이름"),
                                PayloadDocumentation.fieldWithPath("data[].price").description("제품 가격"),
                                PayloadDocumentation.fieldWithPath("data[].contractCount").description("제품 계약 건수"),
                                PayloadDocumentation.fieldWithPath("data[].createdAt").description("제품 생성 날짜"),
                                PayloadDocumentation.fieldWithPath("data[].notes").description("제품 노트")
                        )
                ));
    }

}