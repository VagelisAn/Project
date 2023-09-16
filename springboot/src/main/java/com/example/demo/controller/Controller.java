package com.example.demo.controller;

import com.example.demo.dto.CountryDTO;
import com.example.demo.entity.Countries;
import com.example.demo.entity.Languages;
import com.example.demo.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    final Services services;

    public Controller(Services services) {
        this.services = services;
    }

    @GetMapping("/countries")
    public List<Countries> getCountriesList() {
        return services.getCountriesList();
    }

    @GetMapping("/countrieswithstats")
    public List<CountryDTO> getCountryList() {
        return services.listCountrriesWithStats();
    }

    @GetMapping("/country/{id}")
    public Countries getCountry(@PathVariable("id") int id) {
        return services.getCountryName(id);
    }

    @GetMapping("/languages/{id}")
    public List<Languages> getLanguageByCountryId(@PathVariable("id") int id) {
        return services.getLanguageByCountryId(id);
    }
}
