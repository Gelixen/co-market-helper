package com.example.demo;

import com.example.demo.model.ItemEntity;
import com.example.demo.service.ItemService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HourlyFetch {
    
    @Autowired
    private ItemService itemService;
    
    private static final Logger log = LoggerFactory.getLogger(HourlyFetch.class);

    @Scheduled(cron = "0 0 * * * *")
    public void reportCurrentTime() {
        try {
            int countBefore = itemService.getAllItems().size();
            List<ItemEntity> items = itemService.updateItems();
            int countAfter = itemService.getAllItems().size();
            log.info("Updated {} items, {} new", items.size(), countAfter - countBefore);
        } catch (IOException e) {
            log.error("Failed to update items");
        }
    }

}