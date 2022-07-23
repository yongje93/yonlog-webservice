package com.yonlog.coding.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends Item {
    /**
     * 저자
     */
    private String author;
    /**
     * 출판사
     */
    private String publisher;
}
