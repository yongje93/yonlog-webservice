package com.yonlog.coding.api;

import com.yonlog.coding.config.Constants;
import com.yonlog.coding.domain.item.Item;
import com.yonlog.coding.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Tag(name = "Index API", description = "색인 관련 API 목록")
@RestController
@RequiredArgsConstructor
@Slf4j
public class IndexApiController {

    private final ItemService itemService;

    @Operation(description = "type에 따라 색인을 진행합니다. (book, movie, album)")
    @GetMapping("/api/index/{type}")
    public void index(@PathVariable("type") String type) {
        File indexDirectory = new File(Constants.DEFAULT_INDEX_DIRECTORY + File.separator + "item");

        try (Directory directory = FSDirectory.open(indexDirectory.toPath())) {
            IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()));

            List<Item> itemList = itemService.findItems();

            for (Item item : itemList) {
                Term term = new Term("ID", "item" + item.getId());
                Document document = new Document();
                document.add(new StringField("id", "item" + item.getId(), Field.Store.YES));
                document.add(new StringField("name", item.getName(), Field.Store.YES));
                document.add(new LongPoint("price", item.getPrice()));
                document.add(new LongPoint("stockQuantity", item.getStockQuantity()));

                indexWriter.updateDocument(term, document);
            }
            indexWriter.commit();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
