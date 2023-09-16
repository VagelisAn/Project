package com.example.demo.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.CountryStatDTO;
import com.example.demo.entity.Country;
import com.example.demo.entity.CountryStat;
import com.example.demo.entity.Language;
//import com.example.demo.repository.CountryLanguageRepository;
import com.example.demo.mapper.Mapper;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.CountryStatRepository;
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

    @Autowired
    private CountryStatRepository countryStatRepository;

//    @Autowired
//    private CountryLanguageRepository countryLanguageRepository;

    public List<Country> getCountriesList() {
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

    public List<CountryDTO> listCountrriesWithStats() {

        List<Country> countryList = countryRepository.findAll();
        List<CountryDTO> countryDTOS = new ArrayList<>();

        for (Country country: countryList
             ) {
            CountryDTO countryDto = Mapper.INSTANCE.countryToDto(country);

            System.out.println(country.getName());
            System.out.println(countryDto.getName());

            List<CountryStat> countryStats = countryStatRepository.findCountryStatsById(country.getId());


            if (!countryStats.isEmpty()) {
                List<CountryStatDTO> countryStatDTOS = Mapper.INSTANCE.countryStatsToDto(countryStats);
                countryDto.setCountryStats(countryStatDTOS);
            }
            countryDTOS.add(countryDto);
        }

        return countryDTOS;
    }

}
