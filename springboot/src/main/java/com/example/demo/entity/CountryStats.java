package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country_stats")
public class CountryStats {
    @Id
    @Column(name = "country_id", insertable=false, updatable=false)
    private int id;
    private int year;
    private int population;
    private double gdp;

}
