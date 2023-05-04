package com.sparta.hanghaemarket.controller;

import com.sparta.hanghaemarket.dto.ListResponseDto;
import com.sparta.hanghaemarket.dto.MarketRequestDto;
import com.sparta.hanghaemarket.dto.MarketResponseDto;
import com.sparta.hanghaemarket.message.Message;
import com.sparta.hanghaemarket.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
public class MarketController {

    private final MarketService marketService;

    // 판매 게시글 작성
    @PostMapping("")
    public MarketResponseDto createPost(@RequestBody MarketRequestDto marketRequestDto) {
        return marketService.createPost(marketRequestDto);
    }

    // 판매 게시글 상세 조회
    @GetMapping("/{postId}")
    public MarketResponseDto getPost(@PathVariable Long postId) {
        return marketService.getPost(postId);
    }

    // 판매 게시글 전체 리스트 조회
    @GetMapping("")
    public List<ListResponseDto> getPosts() {
        return marketService.getPosts();
    }

    // 판매 게시글 수정
    @PutMapping("{postId}")
    public MarketResponseDto updatePost(@PathVariable Long postId, @RequestBody MarketRequestDto marketRequestDto) {
        return marketService.updatePost(postId, marketRequestDto);
    }

    // 게시글 삭제
    @DeleteMapping("{postId}")
    public Message deletePost(@PathVariable Long postId) {
        return marketService.deletePost(postId);
    }

}
