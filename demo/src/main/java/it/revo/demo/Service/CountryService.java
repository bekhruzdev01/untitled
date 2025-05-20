package it.revo.demo.service;

import it.revo.demo.entity.Country;
import it.revo.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // Barcha country larni olish
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // ID bo‘yicha country olish
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    // Yangi country yaratish
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    // Country ni yangilash
    public Country updateCountry(Long id, Country countryDetails) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id " + id));
        country.setName(countryDetails.getName());
        country.setCode(countryDetails.getCode());
        return countryRepository.save(country);
    }

    // Country o‘chirish
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
