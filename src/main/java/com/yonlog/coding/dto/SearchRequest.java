package com.yonlog.coding.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SearchRequest {
    /**
     * 검색어
     */
    @NotBlank(message = "검색어를 입력해주세요.")
    private String keyword;

}
