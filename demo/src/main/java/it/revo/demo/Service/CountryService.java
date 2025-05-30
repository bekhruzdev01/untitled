package it.revo.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.revo.demo.entity.Country;
import it.revo.demo.payload.ApiResponse;
import it.revo.demo.repository.countryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final countryRepository countryRepository;
    public ApiResponse AddCountry(Country country){
       countryRepository.save(country);

       return ApiResponse.builder()
       .message("saqlandi")
       .success(true)
       .build();
    }

    public List<Country> GetCountry() {
        return countryRepository.findAll();
    }

    public ApiResponse deleteCountry(Long Id){
        countryRepository.deleteById(Id);
        return ApiResponse.builder().message("O'chirildi").success(true).build();
    }

    public ApiResponse updateCountry(Long id, Country country) {
        country.setId(id);
        countryRepository.save(country);
        return ApiResponse.builder().message("saqlandi").success(true).build();
    }
}
