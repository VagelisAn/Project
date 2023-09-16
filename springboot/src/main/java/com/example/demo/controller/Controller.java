package com.example.demo.controller;

import com.example.demo.dto.CountryDTO;
import com.example.demo.entity.Countries;
import com.example.demo.entity.Languages;
import com.example.demo.services.Services;
import com.example.demo.services.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    final Services services;

    @Autowired
    final CountryServiceImpl countryService;

    public Controller(Services services, CountryServiceImpl countryService) {
        this.services = services;
        this.countryService = countryService;
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


    @GetMapping("/countries/{page}/{size}")
    public Page<Countries> getProductList(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable paging = PageRequest.of(page, size);
        return countryService.findAll(paging);
    }

}
