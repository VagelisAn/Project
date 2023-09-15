//package com.example.demo.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "country_languages")
//public class CountryLanguage {
//
//
//    @OneToOne
//    @JoinColumn(name = "country_id", insertable = false, updatable = false)
//    private Country country;
//
//    @OneToOne
//    @JoinColumn(name = "language_id", insertable = false, updatable = false)
//    private Language language;
//
//    private int official;
//
//}
