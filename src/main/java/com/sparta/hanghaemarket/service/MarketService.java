package com.sparta.hanghaemarket.service;

import com.sparta.hanghaemarket.dto.ListResponseDto;
import com.sparta.hanghaemarket.dto.MarketRequestDto;
import com.sparta.hanghaemarket.dto.MarketResponseDto;
import com.sparta.hanghaemarket.entity.Item;
import com.sparta.hanghaemarket.message.Message;
import com.sparta.hanghaemarket.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketService {
    private final ItemRepository itemRepository;

    Item item;

    // 판매 게시글 작성
    @Transactional
    public MarketResponseDto createPost(MarketRequestDto marketRequestDto) {
        item = itemRepository.save(new Item(marketRequestDto));
        return new MarketResponseDto(item);
    }

    // 판매 게시글 상세 조회
    @Transactional(readOnly = true)
    public MarketResponseDto getPost(Long postId) {
        item = itemRepository.findById(postId).orElseThrow();
        return new MarketResponseDto(item);
    }

    // 판매 게시글 전체 리스트 조회
    @Transactional(readOnly = true)
    public List<ListResponseDto> getPosts() {
        List<Item> items = itemRepository.findAll();
        List<ListResponseDto> itemList = new ArrayList<>();
        for(Item item : items) {
            itemList.add(new ListResponseDto(item));
        }
        return itemList;
    }

    // 판매 게시글 수정
    @Transactional
    public MarketResponseDto updatePost(Long postId, MarketRequestDto marketRequestDto) {
        item = itemRepository.findById(postId).orElseThrow();
        item.update(marketRequestDto);
        return new MarketResponseDto(item);
    }

    // 게시글 삭제
    @Transactional
    public Message deletePost(Long postId) {
        item = itemRepository.findById(postId).orElseThrow();
        itemRepository.deleteById(postId);
        return new Message("삭제완료");
    }
}
