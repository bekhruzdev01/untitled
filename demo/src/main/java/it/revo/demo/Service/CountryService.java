package it.revo.demo.service;

import it.revo.demo.entity.Country;
import it.revo.demo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import it.revo.demo.payload.ApiResponse;
import it.revo.demo.payload.CountryDto;
import it.revo.demo.repository.CountryRepository;

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

    public ApiResponse createCountry(Country country, CountryDto countryDto) {
        Country savedCountry = repository.save(country
        .builder()
        .id(countryDto.getId())
        .name(countryDto.getName())
        .build());

        return ApiResponse.builder()
                .message("Country created successfully")
                .success(true)
                .build();
    }
}
