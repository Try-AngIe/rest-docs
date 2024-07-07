CMS+ Application API Document

made by Sanghun.Kim  – version 0.0.1-SNAPSHOT 

Table of Contents

[1. 상품](#post-api)

[1.1. 상품 목록 조회](#_1_1_상품_목록_조회)

[REQUEST](#_1_1_상품_목록_조회_http_request)

[RESPONSE](#_1_1_상품_목록_조회_http_response)

[1.2. 상품 등록](#_1_2_상품_등록)

[REQUEST](#_1_2_상품_등록_http_request)

[RESPONSE](#_1_2_상품_등록_http_response)

[1.3. 상품 상세 조회](#_1_3_상품_상세_조회)

[REQUEST](#_1_3_상품_상세_조회_http_request)

[RESPONSE](#_1_3_상품_상세_조회_http_response)

[1.4. 상품 수정](#_1_4_상품_수정)

[REQUEST](#_1_4_상품_수정_http_request)

[RESPONSE](#_1_4_상품_수정_http_response)

[1.5. 상품 삭제](#_1_5_상품_삭제)

[REQUEST](#_1_5_상품_삭제_http_request)

[RESPONSE](#_1_5_상품_삭제_http_response)
## <a name="post-api"></a>[1. 상품](#post-api)
### <a name="_1_1_상품_목록_조회"></a>[1.1. 상품 목록 조회](#_1_1_상품_목록_조회)
<table><tr><th colspan="4"><i>Table 1. Request Header Parameter</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">Authorization</td><td valign="top">String</td><td valign="top">필수</td><td valign="top">ACCESS_TOKEN</td></tr>
<tr><td valign="top">X-CSRF</td><td valign="top">String</td><td valign="top">필수</td><td valign="top">CSRF_TOKEN</td></tr>
</table>

<table><tr><th colspan="4"><i>Table 2. Request Query Parameter</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">page</td><td valign="top">Integer</td><td valign="top">필수</td><td valign="top">페이지 번호</td></tr>
<tr><td valign="top">offset</td><td valign="top">Integer</td><td valign="top">필수</td><td valign="top">페이지당 오프셋</td></tr>
<tr><td valign="top">sort</td><td valign="top">String</td><td valign="top">선택</td><td valign="top">정렬 기준</td></tr>
<tr><td valign="top">name</td><td valign="top">String</td><td valign="top">선택</td><td valign="top">상품명으로 검색</td></tr>
<tr><td valign="top">price</td><td valign="top">double</td><td valign="top">선택</td><td valign="top">금액으로 검색</td></tr>
<tr><td valign="top">contractCount</td><td valign="top">Integer</td><td valign="top">선택</td><td valign="top">계약수로 검색</td></tr>
<tr><td valign="top">createdAt</td><td valign="top">String</td><td valign="top">선택</td><td valign="top">생성시기로 검색</td></tr>
<tr><td valign="top">memo</td><td valign="top">String</td><td valign="top">선택</td><td valign="top">비고로 검색</td></tr>
</table>
#### <a name="_1_1_상품_목록_조회_http_request"></a>[REQUEST](#_1_1_상품_목록_조회_http_request)
GET /api/v1/vendor/product?page=1&offset=10 HTTP/1.1

Authorization: ACCESS\_TOKEN

Accept: application/json

Host: localhost
#### <a name="_1_1_상품_목록_조회_http_response"></a>[RESPONSE](#_1_1_상품_목록_조회_http_response)
HTTP/1.1 200 OK

Content-Type: application/json;charset=UTF-8

Content-Length: 723

{

`  `"page" : 1,

`  `"offset" : 10,

`  `"totalPage" : 100,

`  `"totalCount" : 1000,

`  `"data" : [ {

`    `"id" : 1,

`    `"vendorId" : 1001,

`    `"name" : "상품 조회용 데이터1",

`    `"price" : 10.0,

`    `"contractCount" : 10,

`    `"createdDateTime" : "2024-01-01 11:11:11",

`    `"updatedDateTime" : "Null",

`    `"deletedDate" : "Null",

`    `"memo" : "비고 1",

`    `"status" : "STATUS1"

`  `}, {

`    `"id" : 2,

`    `"vendorId" : 1002,

`    `"name" : "상품 조회용 데이터2",

`    `"price" : 20.0,

`    `"contractCount" : 22,

`    `"createdDateTime" : "2024-01-02 11:11:11",

`    `"updatedDateTime" : "2024-01-01 11:11:11",

`    `"deletedDate" : "2024-01-01",

`    `"memo" : "비고 2",

`    `"status" : "STATUS2"

`  `} ]

}
### <a name="_1_2_상품_등록"></a>[1.2. 상품 등록](#_1_2_상품_등록)
<table><tr><th colspan="4"><i>Table 3. Request Header Parameter</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">Authorization</td><td valign="top">String</td><td valign="top">필수</td><td valign="top">ACCESS_TOKEN</td></tr>
<tr><td valign="top">X-CSRF</td><td valign="top">String</td><td valign="top">필수</td><td valign="top">CSRF_TOKEN</td></tr>
</table>

<table><tr><th colspan="4"><i>Table 4. Request Body Parameter</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">name</td><td valign="top">String</td><td valign="top">필수</td><td valign="top">상품명</td></tr>
<tr><td valign="top">price</td><td valign="top">double</td><td valign="top">필수</td><td valign="top">금액</td></tr>
<tr><td valign="top">memo</td><td valign="top">Stirng</td><td valign="top">필수</td><td valign="top">비고</td></tr>
</table>
#### <a name="_1_2_상품_등록_http_request"></a>[REQUEST](#_1_2_상품_등록_http_request)
POST /api/v1/vendor/product HTTP/1.1

Content-Type: application/json;charset=UTF-8

Authorization: ACCESS\_TOKEN

Content-Length: 169

Host: localhost

{

`  `"id" : 1,

`  `"vendorId" : 1003,

`  `"name" : "상품 등록용 데이터1",

`  `"price" : 50.0,

`  `"createdDateTime" : "2024-02-01 11:11:11",

`  `"memo" : "비고1"

}
#### <a name="_1_2_상품_등록_http_response"></a>[RESPONSE](#_1_2_상품_등록_http_response)
HTTP/1.1 200 OK

Content-Type: application/json;charset=UTF-8

Content-Length: 272

{

`  `"id" : 1,

`  `"vendorId" : 1003,

`  `"name" : "상품 등록용 데이터1",

`  `"price" : 50.0,

`  `"contractCount" : 0,

`  `"createdDateTime" : "2024-02-01 11:11:11",

`  `"updatedDateTime" : null,

`  `"deletedDate" : null,

`  `"memo" : "비고1",

`  `"status" : "STATUS1"

}
### <a name="_1_3_상품_상세_조회"></a>[1.3. 상품 상세 조회](#_1_3_상품_상세_조회)
<table><tr><th colspan="4"><i>Table 5. Request Header Parameter</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">Authorization</td><td valign="top">String</td><td valign="top">필수</td><td valign="top">ACCESS_TOKEN</td></tr>
<tr><td valign="top">X-CSRF</td><td valign="top">String</td><td valign="top">필수</td><td valign="top">CSRF_TOKEN</td></tr>
</table>

<table><tr><th colspan="4"><i>Table 6. Request Path Parameter</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">PRODUCT_ID</td><td valign="top">Long</td><td valign="top">필수</td><td valign="top">상품번호</td></tr>
</table>
#### <a name="_1_3_상품_상세_조회_http_request"></a>[REQUEST](#_1_3_상품_상세_조회_http_request)
GET /api/v1/vendor/product/1 HTTP/1.1

Authorization: ACCESS\_TOKEN

Accept: application/json

Host: localhost
#### <a name="_1_3_상품_상세_조회_http_response"></a>[RESPONSE](#_1_3_상품_상세_조회_http_response)
HTTP/1.1 200 OK

Content-Type: application/json;charset=UTF-8

Content-Length: 278

{

`  `"id" : 1,

`  `"vendorId" : 1001,

`  `"name" : "상품 조회용 데이터1",

`  `"price" : 10.0,

`  `"contractCount" : 10,

`  `"createdDateTime" : "2024-01-01 11:11:11",

`  `"updatedDateTime" : "Null",

`  `"deletedDate" : "Null",

`  `"memo" : "비고 1",

`  `"status" : "STATUS1"

}
### <a name="_1_4_상품_수정"></a>[1.4. 상품 수정](#_1_4_상품_수정)
<table><tr><th colspan="4"><i>Table 7. Request Header Parameter</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">Authorization</td><td valign="top">String</td><td valign="top">필수</td><td valign="top">ACCESS_TOKEN</td></tr>
<tr><td valign="top">X-CSRF</td><td valign="top">String</td><td valign="top">필수</td><td valign="top">CSRF_TOKEN</td></tr>
</table>

<table><tr><th colspan="4"><i>Table 8. Request Path Parameter</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">PRODUCT_ID</td><td valign="top">Long</td><td valign="top">필수</td><td valign="top">상품번호</td></tr>
</table>

<table><tr><th colspan="4"><i>Table 9. Request Body Parameter</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">name</td><td valign="top">String</td><td valign="top">선택</td><td valign="top">상품명</td></tr>
<tr><td valign="top">price</td><td valign="top">double</td><td valign="top">선택</td><td valign="top">금액</td></tr>
<tr><td valign="top">notes</td><td valign="top">Stirng</td><td valign="top">선택</td><td valign="top">비고</td></tr>
</table>
#### <a name="_1_4_상품_수정_http_request"></a>[REQUEST](#_1_4_상품_수정_http_request)
PUT /api/v1/vendor/product/2 HTTP/1.1

Content-Type: application/json;charset=UTF-8

Authorization: ACCESS\_TOKEN

Content-Length: 89

Host: localhost

{

`  `"name" : "상품 조회용 데이터2",

`  `"price" : 20.0,

`  `"memo" : "비고 2"

}
#### <a name="_1_4_상품_수정_http_response"></a>[RESPONSE](#_1_4_상품_수정_http_response)
HTTP/1.1 200 OK

Content-Type: application/json;charset=UTF-8

Content-Length: 299

{

`  `"id" : 2,

`  `"vendorId" : 1002,

`  `"name" : "상품 조회용 데이터2",

`  `"price" : 20.0,

`  `"contractCount" : 22,

`  `"createdDateTime" : "2024-01-02 11:11:11",

`  `"updatedDateTime" : "2024-01-01 11:11:11",

`  `"deletedDate" : "2024-01-01",

`  `"memo" : "비고 2",

`  `"status" : "STATUS2"

}
### <a name="_1_5_상품_삭제"></a>[1.5. 상품 삭제](#_1_5_상품_삭제)
<table><tr><th colspan="4"><i>Table 10. Request Header</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">Authorization</td><td valign="top">String</td><td valign="top">필수</td><td valign="top">인증 키</td></tr>
</table>

<table><tr><th colspan="4"><i>Table 11. Request Path Parameter</i></th></tr>
<tr><td valign="top">파라미터</td><td valign="top">타입</td><td valign="top">필수여부</td><td valign="top">설명</td></tr>
<tr><td valign="top">PRODUCT_ID</td><td valign="top">Long</td><td valign="top">필수</td><td valign="top">상품번호</td></tr>
</table>
#### <a name="_1_5_상품_삭제_http_request"></a>[REQUEST](#_1_5_상품_삭제_http_request)
DELETE /api/v1/vendor/product/2 HTTP/1.1

Authorization: ACCESS\_TOKEN

Accept: application/json

Host: localhost
#### <a name="_1_5_상품_삭제_http_response"></a>[RESPONSE](#_1_5_상품_삭제_http_response)
HTTP/1.1 200 OK

Content-Type: application/json;charset=UTF-8

Content-Length: 299

{

`  `"id" : 2,

`  `"vendorId" : 1002,

`  `"name" : "상품 조회용 데이터2",

`  `"price" : 20.0,

`  `"contractCount" : 22,

`  `"createdDateTime" : "2024-01-02 11:11:11",

`  `"updatedDateTime" : "2024-01-01 11:11:11",

`  `"deletedDate" : "2024-01-01",

`  `"memo" : "비고 2",

`  `"status" : "DELETED"

}

Version 0.0.1-SNAPSHOT
Last updated 2024-07-07 18:27:23 +0900 
