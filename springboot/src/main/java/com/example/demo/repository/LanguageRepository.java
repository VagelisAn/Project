package com.example.demo.repository;

import com.example.demo.entity.Languages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Languages, Integer> {
    @Query(
            nativeQuery = true,
            value
                    = "SELECT  l.language_id, l.language FROM languages  as l join country_languages cl on\n" +
                    "cl.language_id = l.language_id  where cl.country_id =:countryId")
    List<Languages> findLanguageByCountryId(@Param("countryId")  int countryId);
}
