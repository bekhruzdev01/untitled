package it.revo.demo.controler;

import it.revo.demo.payload.ApiResponse;
import it.revo.demo.payload.CountryDto;
import it.revo.demo.service.CountryService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;
    @PostMapping
    public HttpEntity<ApiResponse> addCountry(@RequestBody CountryDto countryDto) {
        ApiResponse apiResponse = countryService.createCountry(countryDto);

        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409)
                .body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }
}
