package com.yonlog.coding.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
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
