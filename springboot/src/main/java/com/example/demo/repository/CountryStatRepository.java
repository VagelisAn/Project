package com.example.demo.repository;

import com.example.demo.entity.Continent;
import com.example.demo.entity.CountryStat;
import com.example.demo.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CountryStatRepository extends JpaRepository<CountryStat, Integer> {
    @Query(
            nativeQuery = true,
            value
                    = "SELECT cs.country_id, cs.year, cs.population, cs.gdp " +
                    "FROM nation.country_stats as cs where cs.country_id  =:id")
    List<CountryStat> findCountryStatsById(@Param("id")  int id);

    List<CountryStat> findById(int id);
}
