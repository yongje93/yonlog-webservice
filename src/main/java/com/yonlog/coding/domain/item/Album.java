package com.yonlog.coding.domain.item;

import lombok.Getter;
import lombok.Setter;

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
