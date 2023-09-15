package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.example.demo.entity.Language;
import com.example.demo.services.Services;
import jakarta.websocket.server.PathParam;
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
    final private Services services;

    public Controller(Services services) {
        this.services = services;
    }

    @GetMapping("/countries")
    public List<Country> getCountryList() {
        return services.listAll();
    }

    @GetMapping("/country/{id}")
    public Country getCountry(@PathVariable("id") int id) {
        return services.getCountryName(id);
    }

    @GetMapping("/languages/{id}")
    public List<Language> getLanguageByCountryId(@PathVariable("id") int id) {
        return services.getLanguageByCountryId(id);
    }
}
