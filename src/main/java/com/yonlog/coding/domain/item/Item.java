package com.yonlog.coding.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {

    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

}
