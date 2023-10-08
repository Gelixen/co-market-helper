package com.example.demo.repo;

import com.example.demo.model.ItemEntity;
import com.example.demo.model.ItemGemsGroup;
import com.example.demo.model.ItemGroup;
import com.example.demo.model.ItemGroup2;
import com.example.demo.model.ItemOthersGroup;
import com.example.demo.model.ItemPlusGroup;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {

    @Query(value = "SELECT type,"
            + " subtype,"
            + " quality,"
            + " plus,"
            + " gem1,"
            + " gem2,"
            + " MIN(price) AS minPrice,"
            + " MAX(price) AS maxPrice"
            + " FROM item"
            + " GROUP BY type, subtype, quality, plus, gem1, gem2"
            + " ORDER BY type, subtype, quality, plus, gem1, gem2", nativeQuery = true)
    List<ItemGroup2> getItemsGroup();

    @Query(value = """
            SELECT
                name,
                quality,
                date,
                MIN(price) AS minPrice,
                (SUM(price) - MAX(price) - MIN(price)) / (COUNT(price) - 2) AS averagePrice,
                GROUP_CONCAT(price) AS prices,
                COUNT(market_id) AS volume
            FROM item
            WHERE type = 'Gem'
            GROUP BY name, quality, date
            ORDER BY name, quality, date
            """, nativeQuery = true)
    List<ItemGemsGroup> getGemsGroup();

    @Query(value = """
            SELECT
                name,
                quality,
                date,
                MIN(price) AS minPrice,
                (SUM(price) - MAX(price) - MIN(price)) / (COUNT(price) - 2) AS averagePrice,
                GROUP_CONCAT(price) AS prices,
                COUNT(market_id) AS volume
            FROM item
            WHERE type NOT IN ('Gem', 'Weapon', 'Armor', 'Ring Bracelet', 'Headgear', 'Necklace Bag', 'Boots')
            GROUP BY name, quality, date
            ORDER BY name, quality, date
            """, nativeQuery = true)
    List<ItemOthersGroup> getOthersGroup();

    @Query(value = """
                SELECT
                name,
                quality,
                date,
                MIN(price) AS minPrice,
                (SUM(price) - MAX(price) - MIN(price)) / (COUNT(price) - 2) AS averagePrice,
                GROUP_CONCAT(price) AS prices,
                COUNT(market_id) AS volume
            FROM item
            WHERE type NOT IN ('Gem', 'Weapon', 'Armor', 'Ring Bracelet', 'Headgear', 'Necklace Bag', 'Boots')
            GROUP BY name, quality, date
            ORDER BY name, quality, date
            """, nativeQuery = true)
    List<ItemOthersGroup> getOthersGrouped();
    
    @Query(value = """
            SELECT
                type,
                GROUP_CONCAT(DISTINCT subtype) AS subtypes,
                subtype_alt AS subtypeAlt,
                plus,
                date,
                MIN(price) AS minPrice,
                (SUM(price) - MAX(price) - MIN(price)) / (COUNT(price) - 2) AS averagePrice,
                GROUP_CONCAT(price) AS prices,
                COUNT(market_id) AS volume
            FROM item
            WHERE plus != 0 AND quality != 'Super'
            GROUP BY type, subtype_alt, plus, date
            ORDER BY type, subtype_alt, plus, date
            """, nativeQuery = true)
    List<ItemPlusGroup> getPlusGroup();
}