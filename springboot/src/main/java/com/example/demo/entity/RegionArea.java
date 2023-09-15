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
@Table(name = "region_areas")
public class RegionArea {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String regionNaame;
    private double region_area;

}
