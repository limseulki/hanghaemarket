package com.sparta.hanghaemarket.dto;

import com.sparta.hanghaemarket.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListResponseDto {
    private Long id;
    private String title;
    private String username;
    private int price;

    public ListResponseDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.username = "임슬기";
        this.price = item.getPrice();
    }
}
