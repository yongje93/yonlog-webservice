package com.yonlog.coding.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends Item {

    private String author;

    private String publisher;
}
