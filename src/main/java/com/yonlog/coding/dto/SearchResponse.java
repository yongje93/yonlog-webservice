package com.yonlog.coding.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SearchResponse {

    private List<Map<String, Object>> result;

    private String message;

}
