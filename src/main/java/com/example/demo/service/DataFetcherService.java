package com.example.demo.service;

import com.example.demo.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DataFetcherService {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public List<Item> fetchItems() throws IOException {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        
        URL url = new URL("https://conqueronline.net/Community/GetItems");
//        Item[] list = mapper.readValue(url, Item[].class);
        List<Item> allItems = OBJECT_MAPPER.readValue(url, new TypeReference<>() {});

        return filterEuItems(allItems);
//        return MODEL_MAPPER.map(euOnlyItems, new TypeToken<List<ItemEntity>>() {}.getType());
    }

    private static List<Item> filterEuItems(List<Item> items) {
        return items.stream()
                .filter(item -> item.getServer().equals("Classic_EU"))
                .collect(Collectors.toList());
    }
}