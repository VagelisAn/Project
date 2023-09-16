package com.example.demo.repository;

import com.example.demo.entity.CountryStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryStatRepository extends JpaRepository<CountryStats, Integer> {
    @Query(
            nativeQuery = true,
            value
                    = "SELECT cs.country_id, cs.year, cs.population, cs.gdp " +
                    "FROM nation.country_stats as cs where cs.country_id  =:id")
    List<CountryStats> findCountryStatsById(@Param("id")  int id);

    List<CountryStats> findById(int id);
}
