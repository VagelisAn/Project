package com.example.demo.repository;

import com.example.demo.entity.Continent;
import com.example.demo.entity.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, Integer> {
}
