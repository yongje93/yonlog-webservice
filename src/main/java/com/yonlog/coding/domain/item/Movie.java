package com.yonlog.coding.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

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
