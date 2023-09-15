package com.example.demo.services;
import java.util.List;
import java.util.Optional;


import com.example.demo.entity.Country;
import com.example.demo.entity.Language;
//import com.example.demo.repository.CountryLanguageRepository;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.LanguageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Services {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private LanguageRepository languageRepository;

//    @Autowired
//    private CountryLanguageRepository countryLanguageRepository;

    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    public Country getCountryName(int id) {
        Optional<Country> country = countryRepository.findById(id);
        if(country.isEmpty()){
            throw new RuntimeException("Error");
        }
        return country.get();
    }

    public List<Language> getLanguageByCountryId(int id) {
        return languageRepository.findLanguageByCountryId(id);
    }

}
