package com.example.demo.repository;

import com.example.demo.entity.Continents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continents, Integer> {
}
