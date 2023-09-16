package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "country_id", sequenceName = "id_sequence", initialValue = 1)
    @Column(name = "country_id")
    private int id;
    private String name;
    private double area;
    @Column(name = "national_day")
    private Date nationalDay;
    @Column(name = "country_code2")
    private String countryCode2;
    @Column(name = "country_code3")
    private String countryCode3;
//    @Column(name = "region_id")
//    private Date region;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<CountryStat> countryStats;
}
