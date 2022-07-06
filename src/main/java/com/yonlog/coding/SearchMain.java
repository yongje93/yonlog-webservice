package com.yonlog.coding;

import com.yonlog.coding.domain.SearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

@Slf4j
public class SearchMain {

    public void doSearch(SearchRequest searchRequest) {
        File indexDirectory = new File(Constants.DEFAULT_INDEX_DIRECTORY + File.separator + "book");

        try (Directory directory = FSDirectory.open(indexDirectory.toPath())) {
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
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BooleanQuery.Builder setBooleanQueryBuilder(SearchRequest searchRequest) {
        log.info("name: {}", searchRequest.getName());
        log.info("author: {}", searchRequest.getAuthor());

        TermQuery nameQuery = new TermQuery(new Term("name", searchRequest.getName()));
        TermQuery authorQuery = new TermQuery(new Term("author", searchRequest.getAuthor()));

        BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
        booleanQueryBuilder.add(nameQuery, BooleanClause.Occur.MUST);
        booleanQueryBuilder.add(authorQuery, BooleanClause.Occur.MUST);

        return booleanQueryBuilder;
    }

    public static void main(String[] args) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setName("자바의 정석");
        searchRequest.setAuthor("남궁성");

        SearchMain searchMain = new SearchMain();
        searchMain.doSearch(searchRequest);
    }
}
