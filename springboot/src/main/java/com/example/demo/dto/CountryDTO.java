package com.example.demo.dto;

import com.example.demo.entity.CountryStat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CountryDTO {

    private int id;
    private String name;
    private double area;
    private Date nationalDay;
    private String countryCode2;
    private String countryCode3;
    private List<CountryStatDTO> countryStats;
    private boolean expanded = false;
}
