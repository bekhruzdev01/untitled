package com.example.demo.service;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
    }

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    public List<Country> searchCountries(String keyword) {
        return countryRepository.findByNameContainingIgnoreCase(keyword);
    }
}
