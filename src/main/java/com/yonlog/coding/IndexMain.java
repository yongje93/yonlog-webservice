package com.yonlog.coding;

import com.yonlog.coding.domain.item.Book;
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexMain {

    public void doIndex() {
        File indexDirectory = new File(Constants.DEFAULT_INDEX_DIRECTORY + File.separator + "book");

        try (Directory directory = FSDirectory.open(indexDirectory.toPath())) {
            IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()));

            List<Book> bookList = getTestData();

            for (Book book : bookList) {
                Term term = new Term("ID", "book" + book.getId());
                Document document = new Document();
                document.add(new StringField("id", "book" + book.getId(), Field.Store.YES));
                document.add(new StringField("name", book.getName(), Field.Store.YES));
                document.add(new StringField("author", book.getAuthor(), Field.Store.YES));
                document.add(new LongPoint("price", book.getPrice()));
                document.add(new LongPoint("stockQuantity", book.getStockQuantity()));
                document.add(new StringField("publisher", book.getPublisher(), Field.Store.YES));

                indexWriter.updateDocument(term, document);
            }
            indexWriter.commit();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getTestData() {
        Book book1 = createBook(1, "자바 ORM 표준 JPA 프로그래밍", 38700, 100, "김영한", "에이콘출판");
        Book book2 = createBook(2, "자바의 정석", 27000, 50, "남궁성", "도우출판");
        Book book3 = createBook(3, "리팩터링", 31500, 60, "마틴 파울러", "한빛미디어");
        Book book4 = createBook(4, "이펙티브 자바 3/E", 32400, 70, "조슈아 블로크", "인사이트");
        Book book5 = createBook(5, "이것이 자바다", 27000, 30, "신용권", "한빛미디어");

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);

        return bookList;
    }

    private Book createBook(long id, String name, int price, int stockQuantity, String author, String publisher) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        book.setAuthor(author);
        book.setPublisher(publisher);

        return book;
    }

    public static void main(String[] args) {
        IndexMain indexMain = new IndexMain();
        indexMain.doIndex();
    }
}
