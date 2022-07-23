package com.yonlog.coding.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie extends Item {
    /**
     * 감독명
     */
    private String director;
    /**
     * 배우명
     */
    private String actor;
}
