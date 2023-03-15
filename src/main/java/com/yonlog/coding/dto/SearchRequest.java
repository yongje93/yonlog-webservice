package com.yonlog.coding.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {
    /**
     * 검색어
     */
    @NotBlank(message = "검색어를 입력해주세요.")
    private String keyword;

}
