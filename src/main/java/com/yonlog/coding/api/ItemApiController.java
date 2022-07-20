package com.yonlog.coding.api;

import com.yonlog.coding.domain.item.Item;
import com.yonlog.coding.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemApiController {
    private final ItemService itemService;

    @GetMapping("/api/items")
    public List<Item> itemList() {
        return itemService.findItems();
    }
}
