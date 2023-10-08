package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.model.ItemEntity;
import com.example.demo.repo.ItemRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final DataFetcherService dataFetcherService;

    @Autowired
    public ItemService(
            ItemRepository itemRepository,
            ItemMapper itemMapper,
            DataFetcherService dataFetcherService
    ) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.dataFetcherService = dataFetcherService;
    }

    public List<ItemEntity> updateItems() throws IOException {
        List<Item> items = dataFetcherService.fetchItems();
        List<ItemEntity> itemEntities = itemMapper.toItemEntities(items);
        return (List<ItemEntity>) itemRepository.saveAll(itemEntities);
    }

    public List<ItemEntity> getAllItems() {
        return (List<ItemEntity>) itemRepository.findAll();
    }
}