package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.example.demo.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    final private Services services;

    public Controller(Services services) {
        this.services = services;
    }

    @GetMapping("/products")
    public List<Country> list() {
        return services.listAll();
    }
}
