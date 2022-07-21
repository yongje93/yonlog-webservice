package com.yonlog.coding.service;

import com.yonlog.coding.domain.item.Item;

import java.util.List;

public interface ItemService {
    List<Item> findItems();

    void saveItem(Item item);
}
