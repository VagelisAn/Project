package com.example.demo.mapper;

import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.CountryStatDTO;
import com.example.demo.entity.Country;
import com.example.demo.entity.CountryStat;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper(componentModel="spring")
public interface Mapper {
    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

//    @Mapping(source = "name", target = "name", qualifiedByName = "countryStatsDto")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "countryCode3", target = "countryCode3")
    public CountryDTO countryToDto(Country country);

//    @Named("countryStatsDto")
    public List<CountryStatDTO> countryStatsToDto(List<CountryStat> countryStatList);

}
