package com.example.demo.service;

import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    // Mamlakatga tegishli regionlarni olish
    public List<Region> getRegionsByCountryId(Long countryId) {
        return regionRepository.findByCountryId(countryId);
    }

    // Yangi regionni saqlash
    public void saveRegion(Region region) {
        regionRepository.save(region);
    }

    // Regionlarni qidirish
    public List<Region> searchRegions(String keyword) {
        return regionRepository.findByNameContainingIgnoreCase(keyword);
    }
}
