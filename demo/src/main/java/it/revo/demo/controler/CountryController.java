package it.revo.demo.controler;

import it.revo.demo.entity.Country;
import it.revo.demo.payload.CountryDto;
import it.revo.demo.service.CountryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAll() {
        return countryService.getAllCountries();
    }

    @PostMapping
    public Country create(@RequestBody Country country) {
        CountryDto countryDto = new CountryDto();
        return countryService.createCountry(country, countryDto);
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable Long id, @RequestBody Country country) {
        return countryService.updateCountry(id, country);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
