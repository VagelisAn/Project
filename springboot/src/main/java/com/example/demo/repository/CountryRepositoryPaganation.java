package com.example.demo.repository;

import com.example.demo.entity.Countries;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepositoryPaganation extends PagingAndSortingRepository<Countries, Long> {

}
