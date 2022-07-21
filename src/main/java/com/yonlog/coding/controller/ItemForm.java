package com.yonlog.coding.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemForm {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    // Book 속성
    private String author;
    private String publisher;

    // Album 속성
    private String artist;
    private String etc;

    // Movie 속성
    private String director;
    private String actor;
}
