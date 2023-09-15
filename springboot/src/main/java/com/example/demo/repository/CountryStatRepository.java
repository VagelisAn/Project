package com.example.demo.repository;

import com.example.demo.entity.Continent;
import com.example.demo.entity.CountryStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryStatRepository extends JpaRepository<CountryStat, Integer> {
}
