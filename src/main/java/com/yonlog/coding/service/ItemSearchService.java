package com.yonlog.coding.service;

import com.yonlog.coding.config.Constants;
import com.yonlog.coding.dto.SearchRequest;
import com.yonlog.coding.dto.SearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ItemSearchService {

    public SearchResponse search(SearchRequest searchRequest) {
        log.info("keyword: {}", searchRequest.getKeyword());

        SearchResponse response = new SearchResponse();

        File indexDirectory = new File(Constants.DEFAULT_INDEX_DIRECTORY + File.separator + "book");

        try (Directory directory = FSDirectory.open(indexDirectory.toPath())) {
            List<Map<String, Object>> resultList = new ArrayList<>();

            Map<String, Object> result = new HashMap<>();

            IndexSearcher indexSearcher = new IndexSearcher(DirectoryReader.open(directory));

            BooleanQuery.Builder booleanQueryBuilder = setBooleanQueryBuilder(searchRequest);

            log.info("search start !!");

            TopDocs topDocs = indexSearcher.search(booleanQueryBuilder.build(), 10);

            long searchCount = topDocs.totalHits.value;

            log.info("search count: {}", searchCount);

            for (int index = 0; index < searchCount; index++) {
                Document document = indexSearcher.doc(topDocs.scoreDocs[index].doc);
                log.info("===============================");
                log.info(" - id : {}", document.get("id"));
                log.info(" - name : {}", document.get("name"));
                log.info(" - author : {}", document.get("author"));
                log.info("===============================");

                result.put("id", document.get("id"));
                result.put("name", document.get("name"));
                result.put("author", document.get("author"));

                resultList.add(result);
            }

            response.setResult(resultList);

        } catch (IOException e) {
            log.error("search error!! {}", e.getMessage());
            response.setMessage(e.getMessage());
        }

        return response;
    }

    public BooleanQuery.Builder setBooleanQueryBuilder(SearchRequest searchRequest) {
        TermQuery nameQuery = new TermQuery(new Term("name", searchRequest.getKeyword()));
//        TermQuery authorQuery = new TermQuery(new Term("author", searchRequest.getKeyword()));

        BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
        booleanQueryBuilder.add(nameQuery, BooleanClause.Occur.MUST);
//        booleanQueryBuilder.add(authorQuery, BooleanClause.Occur.MUST);

        return booleanQueryBuilder;
    }
}
