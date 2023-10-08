package com.example.demo.model;

import java.time.LocalDate;

public interface ItemGemsGroup {
    String getName();
    String getQuality();
    LocalDate getDate();
    Integer getMinPrice();
    Integer getAveragePrice();
    Integer getMaxPrice();
    String getPrices();
    Integer getVolume();
}