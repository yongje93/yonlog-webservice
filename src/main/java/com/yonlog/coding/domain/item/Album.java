package com.yonlog.coding.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
public class Album extends Item {
    /**
     * 아티스트명
     */
    private String artist;
    /**
     * 기타
     */
    private String etc;
}
