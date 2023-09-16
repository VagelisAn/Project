package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "regions")
public class Regions implements Serializable {
    @Id
    @Column(name = "region_id", insertable=false, updatable=false)
    private int regionId;
    private String name;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "continentId", referencedColumnName = "continent_id")
    private Continents continents;

}
