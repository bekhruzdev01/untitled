package it.revo.demo.service;

import it.revo.demo.entity.Country;
import it.revo.demo.repository.CountryRepository;
import it.revo.demo.payload.ApiResponse;
import it.revo.demo.payload.CountryDTO;
import it.revo.demo.payload.CountryResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    CountryRepository repository;

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
