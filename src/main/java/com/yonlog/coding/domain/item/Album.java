package com.yonlog.coding.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

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
