package com.example.demo.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.CountryStatDTO;
import com.example.demo.entity.Countries;
import com.example.demo.entity.CountryStats;
import com.example.demo.entity.Languages;
import com.example.demo.mapper.Map;
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

    public List<Countries> getCountriesList() {
        return countryRepository.findAll();
    }

    public Countries getCountryName(int id) {
        Optional<Countries> country = countryRepository.findById(id);
        if(country.isEmpty()){
            throw new RuntimeException("Error");
        }
        return country.get();
    }

    public List<Languages> getLanguageByCountryId(int id) {
        return languageRepository.findLanguageByCountryId(id);
    }

    public List<CountryDTO> listCountrriesWithStats() {

        List<Countries> countriesList = countryRepository.findAll();
        List<CountryDTO> countryDTOS = new ArrayList<>();

        for (Countries countries : countriesList
             ) {
            CountryDTO countryDto = Map.INSTANCE.countryToDto(countries);

            System.out.println(countries.getName());
            System.out.println(countryDto.getName());

            List<CountryStats> countryStats = countryStatRepository.findCountryStatsById(countries.getId());


            if (!countryStats.isEmpty()) {
                List<CountryStatDTO> countryStatDTOS = Map.INSTANCE.countryStatsToDto(countryStats);
                countryDto.setCountryStats(countryStatDTOS);
            }
            countryDTOS.add(countryDto);
        }

        return countryDTOS;
    }

}
