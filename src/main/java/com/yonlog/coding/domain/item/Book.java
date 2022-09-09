package com.yonlog.coding.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
