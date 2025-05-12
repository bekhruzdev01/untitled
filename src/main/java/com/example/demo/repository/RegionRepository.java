package com.example.demo.repository;

import com.example.demo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    List<Region> findByCountryId(Long countryId);
    List<Region> findByNameContainingIgnoreCase(String keyword);
}
