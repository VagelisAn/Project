package com.example.demo.entity;

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
@Entity
@Table(name = "countries")
public class Countries {
    @Id
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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "regionId", referencedColumnName = "region_id")
    private Regions regions;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="country_id")
    private List<CountryStats> countryStats;
}
