package com.example.demo.model;

import java.time.LocalDate;

public interface ItemPlusGroup {
    String getType();
    String getSubtypes();
    String getSubtypeAlt();
    String getPlus();
    LocalDate getDate();
    Integer getMinPrice();
    Integer getAveragePrice();
    Integer getMaxPrice();
    String getPrices();
    Integer getVolume();

}