package com.yonlog.coding.controller;

import com.yonlog.coding.domain.item.Item;
import com.yonlog.coding.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/books")
    public List<Item> bookList() {
        return itemService.findAll();
    }
}
