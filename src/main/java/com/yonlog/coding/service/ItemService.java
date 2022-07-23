package com.yonlog.coding.service;

import com.yonlog.coding.domain.item.Item;

import java.util.List;

public interface ItemService {
    List<Item> findItems();

    Item findOne(Long id);

    void saveItem(Item item);

    void updateItem(Long itemId, String name, int price, int stockQuantity);
}
