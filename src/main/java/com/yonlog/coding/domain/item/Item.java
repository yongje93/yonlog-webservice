package com.yonlog.coding.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {
    /**
     * 일련번호
     */
    private Long id;
    /**
     * 이름
     */
    private String name;
    /**
     * 가격
     */
    private int price;
    /**
     * 수량
     */
    private int stockQuantity;

}
