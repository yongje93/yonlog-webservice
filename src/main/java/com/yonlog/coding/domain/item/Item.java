package com.yonlog.coding.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {
    /**
     * 일련번호
     */
    @Id @GeneratedValue
    @Column(name = "item_id")
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
