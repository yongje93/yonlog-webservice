package com.yonlog.coding.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
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
