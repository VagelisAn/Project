package com.example.demo.services.impl;

import com.example.demo.dto.CountryDTO;
import com.example.demo.entity.Countries;
import com.example.demo.repository.CountryRepositoryPaganation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepositoryPaganation countryRepositoryPaganation;

    @Override
    public Page<Countries> findAll(Pageable pageable) {
        return countryRepositoryPaganation.findAll(pageable);
    }
}
