package com.example.test.controller;

import com.example.test.dto.PostRequestDto;
import com.example.test.dto.PostResponseDto;
import com.example.test.entity.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/post")
    public ResponseEntity getPost() {
        Post post = buildPost("GET 테스트1", "GET 테스트1");
        PostResponseDto postResponseDto = buildResponseDto(post);
        System.out.println("Response DTO: " + postResponseDto);
        return ResponseEntity.ok(postResponseDto);
    }

    @PostMapping("/post")
    public ResponseEntity createPost(@RequestBody PostRequestDto postRequestDto) {
        Post post = buildPost(postRequestDto.getName(), postRequestDto.getContent());
        PostResponseDto postResponseDto = buildResponseDto(post);
        System.out.println("Response DTO: " + postResponseDto);
        return ResponseEntity.ok(postResponseDto);
    }

    private static Post buildPost(String name, String content) {
        return  Post.builder()
                .name(name)
                .content(content)
                .build();
    }

    private static PostResponseDto buildResponseDto(Post post) {
        PostResponseDto postResponseDto = PostResponseDto.builder()
                .name(post.getName())
                .content(post.getContent())
                .build();
        return postResponseDto;
    }
}