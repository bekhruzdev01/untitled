package com.example.demo.service;

import com.example.demo.entity.Country;
import com.example.demo.entity.Region;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;

    public RegionService(RegionRepository regionRepository, CountryRepository countryRepository) {
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;
    }

    public List<Region> getRegionsByCountryId(Long countryId) {
        return regionRepository.findByCountryId(countryId);
    }

    public List<Country> searchCountries(String keyword) {
        return countryRepository.findByNameContainingIgnoreCase(keyword);
    }
}
