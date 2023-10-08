package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.model.ItemEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public List<ItemEntity> toItemEntities(List<Item> items) {
        return items.stream()
                .map(this::toItemEntity)
                .collect(Collectors.toList());
    }

    public ItemEntity toItemEntity(Item item) {
        return ItemEntity.builder()
                .id(item.getId())
                .date(LocalDate.now())
                .name(item.getName())
                .marketId(item.getMarketId())
                .type(item.getType())
                .subtype(item.getSubtype())
                .subtypeAlt(remapAlternativeSubtype(item.getSubtype()))
                .gem1(item.getGem1())
                .gem2(item.getGem2())
                .quality(item.getQuality())
                .plus(item.getPlus())
                .price(item.getPrice())
                .build();

//        500289 - 126 lvl
//        500299 - 127 lvl
//        500309 - 128 lvl
//        500319 - 129 lvl
//        500329 - 130 lvl
    }

    private static String remapAlternativeSubtype(String subtype) {
        return switch (subtype) {
            case "Dagger", "Hammer", "Hook", "Sword", "Blade", "Whip", "Axe", "Club", "Scepter" ->
                    "1-hand";
            case "Spear", "Wand", "Glaive", "Halbert", "Poleaxe" -> "2-hand";
            default -> subtype;
        };
    }
}