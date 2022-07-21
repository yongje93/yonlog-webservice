package com.yonlog.coding.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie extends Item {

    private String director;

    private String actor;
}
