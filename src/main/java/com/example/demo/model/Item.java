package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Item {

    @JsonProperty("ServerName")
    private String server;

    @JsonProperty("ItemId")
    private Integer marketId;

    @JsonProperty("AttributeId")
    private Integer id;

    @JsonProperty("AttributeName")
    private String name;

    @JsonProperty("QualityName")
    private String quality;

    @JsonProperty("AdditionLevel")
    private Integer plus;

    @JsonProperty("Gem1")
    private String gem1;

    @JsonProperty("Gem2")
    private String gem2;

    @JsonProperty("Price")
    private Integer price;

    @JsonProperty("ItemMajorClass")
    private String type;

    @JsonProperty("ItemMinorClass")
    private String subtype;

}