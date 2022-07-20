package com.yonlog.coding.repository;

import com.yonlog.coding.domain.item.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper {
    List<Item> findItems();
}
