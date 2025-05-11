package com.example.demo.service;

import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRegionsByCountryId(Long countryId) {
        return regionRepository.findByCountryId(countryId);
    }
}
