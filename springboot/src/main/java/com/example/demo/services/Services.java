package com.example.demo.services;
import java.util.List;


import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Services {

    @Autowired
    private CountryRepository repo;

    public List<Country> listAll() {
        return repo.findAll();
    }

    public Country get(Integer id) {
        return repo.findById(id).get();
    }

}
