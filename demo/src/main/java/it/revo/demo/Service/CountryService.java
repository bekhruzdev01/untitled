package it.revo.demo.service;

import it.revo.demo.entity.Country;
import it.revo.demo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import it.revo.demo.payload.ApiResponse;
import it.revo.demo.payload.CountryDTO;
import it.revo.demo.payload.CountryResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository repository;

    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    public ApiResponse createCountry(Country country) {
        Country savedCountry = repository.save(country);
        return ApiResponse.builder()
                .message("Country created successfully")
                .success(true)
                .build();
    }
}
