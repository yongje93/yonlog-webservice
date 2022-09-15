package com.yonlog.coding.repository;

import com.yonlog.coding.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findItemById(@Param("id") Long id);
}
