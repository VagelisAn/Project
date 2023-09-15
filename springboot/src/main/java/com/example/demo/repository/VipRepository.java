package com.example.demo.repository;

import com.example.demo.entity.Continent;
import com.example.demo.entity.Vip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VipRepository extends JpaRepository<Vip, Integer> {
}
