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
public class CountryStat {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "country_id", sequenceName = "id_sequence", initialValue = 1)
    @Column(name = "country_id", insertable=false, updatable=false)
    private int id;
    private int year;
    private int population;
    private double gdp;

}
