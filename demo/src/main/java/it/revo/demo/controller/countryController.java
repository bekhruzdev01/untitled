package it.revo.demo.controller;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.revo.demo.entity.Country;
import it.revo.demo.payload.ApiResponse;
import it.revo.demo.service.CountryService;
import it.revo.demo.service.CountryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class countryController {
    private final CountryService cService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> AddCountry(@RequestBody Country country){
        cService.AddCountry(country);

        return ResponseEntity.ok(ApiResponse.builder().message("saqlandi").success(true).build());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Country>> GetAllCountries() {
        return ResponseEntity.ok(cService.GetCountry());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteCountry(@PathVariable Long id) {
        cService.deleteCountry(id);
        return ResponseEntity.ok(ApiResponse.builder().message("o'chirildi").success(true).build());
    }

}
