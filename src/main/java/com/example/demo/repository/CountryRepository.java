package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByNameContainingIgnoreCase(String keyword);
}
