package com.example.demo.model;

import java.time.LocalDate;

public interface ItemOthersGroup {
    String getName();
    String getQuality();
    LocalDate getDate();
    Integer getMinPrice();
    Integer getAveragePrice();
    String getPrices();
    Integer getVolume();
}