package com.example.demo.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    private Integer marketId;

    private LocalDate date;

    private Integer id;

    private String name;

    private String quality;

    private Integer plus;
    
    private String gem1;
    
    private String gem2;

    private Integer price;

    private String type;

    private String subtype;

    private String subtypeAlt;
}