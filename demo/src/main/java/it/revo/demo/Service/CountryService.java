package it.revo.demo.service;

import org.springframework.stereotype.Service;

import it.revo.demo.entity.Country;
import it.revo.demo.payload.ApiResponse;
import it.revo.demo.repository.countryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class countryService {
    private final countryRepository countryRepository;
    public ApiResponse AddCountry(Country country){
       countryRepository.save(country);

       return ApiResponse.builder()
       .message("saqlandi")
       .success(true)
       .build();
    }
}
