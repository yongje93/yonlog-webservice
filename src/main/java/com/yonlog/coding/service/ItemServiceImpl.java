package com.yonlog.coding.service;

import com.yonlog.coding.domain.item.Item;
import com.yonlog.coding.repository.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;

    @Override
    public List<Item> findItems() {
        return itemMapper.findItems();
    }

    @Override
    public void saveItem(Item item) {
        itemMapper.save(item);
    }
}
