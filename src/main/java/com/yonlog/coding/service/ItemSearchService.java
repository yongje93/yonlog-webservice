package com.yonlog.coding.service;

import com.yonlog.coding.domain.SearchRequest;
import com.yonlog.coding.domain.SearchResponse;

public interface ItemSearchService {

    SearchResponse search(SearchRequest searchRequest);
}
