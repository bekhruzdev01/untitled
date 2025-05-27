package it.revo.demo.controller;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.revo.demo.entity.Country;
import it.revo.demo.payload.ApiResponse;
import it.revo.demo.service.countryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class countryController {
    private final countryService cService;
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> AddCountry(@RequestBody Country country){
        cService.AddCountry(country);

        return ResponseEntity.ok(ApiResponse.builder().message("saqlandi").success(true).build());
    }

}
