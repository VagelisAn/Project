package com.example.demo.repository;

import com.example.demo.entity.Continent;
import com.example.demo.entity.RegionArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionAreaRepository extends JpaRepository<RegionArea, Integer> {
}
