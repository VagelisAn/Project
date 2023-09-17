package com.example.demo.repository;

import com.example.demo.entity.CountryStats;
import com.example.demo.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RegionRepository extends JpaRepository<Regions, Integer> {
    @Query(
            nativeQuery = true,
            value
                    = "SELECT DISTINCT r.name FROM regions as r")
    List<String> findAllRegions();

}
