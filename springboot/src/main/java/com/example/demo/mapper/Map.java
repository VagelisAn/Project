package com.example.demo.mapper;

import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.CountryStatDTO;
import com.example.demo.entity.Countries;
import com.example.demo.entity.CountryStats;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface Map {
    Map INSTANCE = Mappers.getMapper(Map.class);

//    @Mapping(source = "name", target = "name", qualifiedByName = "countryStatsDto")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "countryCode3", target = "countryCode3")
    public CountryDTO countryToDto(Countries countries);

//    @Named("countryStatsDto")
    public List<CountryStatDTO> countryStatsToDto(List<CountryStats> countryStatsList);

}
