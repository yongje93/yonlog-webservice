package com.yonlog.coding.service;

import com.yonlog.coding.domain.item.Item;
import com.yonlog.coding.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    @Transactional
    public void saveItem(Item item) {
        repository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item findItem = repository.findItemById(itemId);
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems() {
        return repository.findAll();
    }

    public Item findOne(Long itemId) {
        return repository.findItemById(itemId);
    }

}
