package com.yonlog.coding.repository;

import com.yonlog.coding.domain.item.Book;
import com.yonlog.coding.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void itemTest() {
        Book book1 = createBook("자바 ORM 표준 JPA 프로그래밍", 38700, 100, "김영한", "에이콘출판");
        Book book2 = createBook("자바의 정석", 27000, 50, "남궁성", "도우출판");
        itemRepository.save(book1);
        itemRepository.save(book2);

        Optional<Item> findBook1 = itemRepository.findById(book1.getId());
        assertThat(findBook1.get().getName()).isEqualTo("자바 ORM 표준 JPA 프로그래밍");
    }

    private Book createBook(String name, int price, int stockQuantity, String author, String publisher) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        book.setAuthor(author);
        book.setPublisher(publisher);
        return book;
    }
}