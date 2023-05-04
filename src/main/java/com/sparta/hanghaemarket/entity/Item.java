package com.sparta.hanghaemarket.entity;

import com.sparta.hanghaemarket.dto.MarketRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String username;

    public Item(MarketRequestDto marketRequestDto) {
        this.title = marketRequestDto.getTitle();
        this.content = marketRequestDto.getContent();
        this.price = marketRequestDto.getPrice();
        this.username = marketRequestDto.getUsername();
    }

    public void update(MarketRequestDto marketRequestDto) {
        this.title = marketRequestDto.getTitle();
        this.content = marketRequestDto.getContent();
        this.price = marketRequestDto.getPrice();
    }
}
