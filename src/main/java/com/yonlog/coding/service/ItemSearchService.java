package com.yonlog.coding.service;

import com.yonlog.coding.dto.SearchRequest;
import com.yonlog.coding.dto.SearchResponse;

public interface ItemSearchService {

    SearchResponse search(SearchRequest searchRequest);
}
