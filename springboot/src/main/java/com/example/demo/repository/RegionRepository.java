package com.example.demo.repository;

import com.example.demo.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RegionRepository extends JpaRepository<Regions, Integer> {
}
