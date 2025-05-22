package com.example.demo.service;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    public Optional<Country> getCountryById(Long id) {
        return repository.findById(id);
    }

    public Country createCountry(Country country) {
        return repository.save(country);
    }

    public Country updateCountry(Long id, Country countryDetails) {
        Country country = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id " + id));
        country.setName(countryDetails.getName());
        country.setCode(countryDetails.getCode());
        return repository.save(country);
    }

    public void deleteCountry(Long id) {
        repository.deleteById(id);
    }
}
