package com.example.demo.controller;

import static org.hibernate.internal.util.collections.CollectionHelper.toMap;

import com.example.demo.model.ItemEntity;
import com.example.demo.model.ItemGemsGroup;
import com.example.demo.model.ItemGroup;
import com.example.demo.model.ItemGroup2;
import com.example.demo.model.ItemOthersGroup;
import com.example.demo.model.ItemPlusGroup;
import com.example.demo.repo.ItemRepository;
import com.example.demo.service.DataFetcherService;
import com.example.demo.service.ItemMapper;
import com.example.demo.service.ItemService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo")
public class MainController {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final ItemService itemService;
    private final DataFetcherService dataFetcherService;

    @Autowired
    public MainController(
            ItemRepository itemRepository,
            ItemMapper itemMapper,
            ItemService itemService,
            DataFetcherService dataFetcherService
    ) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.itemService = itemService;
        this.dataFetcherService = dataFetcherService;
    }

    @GetMapping(path = "/update")
    public Iterable<ItemEntity> updateItems() throws IOException {
        return itemService.updateItems();
    }

    @GetMapping(path = "/total")
    public List<ItemGroup2> getTotal() {
        return itemRepository.getItemsGroup();
    }

    @GetMapping(path = "/plus")
    public Map<String, List<ItemPlusGroup>> getPlus() {
        return itemRepository.getPlusGroup().stream()
                .collect(Collectors.groupingBy(itemPlusGroup -> itemPlusGroup.getSubtypeAlt() + " " + itemPlusGroup.getPlus()));
    }

    @GetMapping(path = "/gems")
    public Map<String, List<ItemGemsGroup>> getGems() {
        return itemRepository.getGemsGroup().stream()
                .collect(Collectors.groupingBy(itemGemsGroup -> itemGemsGroup.getName() + " " + itemGemsGroup.getQuality()));
    }
    
    @GetMapping(path = "/others")
    public List<ItemOthersGroup> getOthers() {
        return itemRepository.getOthersGroup();
    }

    @GetMapping(path = "/others/grouped")
    public Map<String, List<ItemOthersGroup>> getOthersGrouped() {
        return itemRepository.getOthersGrouped().stream()
                .collect(Collectors.groupingBy(ItemOthersGroup::getName));
    }

    @GetMapping(path = "/all")
    public Iterable<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }
}