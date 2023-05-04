package com.sparta.hanghaemarket.dto;

import com.sparta.hanghaemarket.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MarketResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public MarketResponseDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
        this.username = "임슬기";
    }
}
