package it.revo.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.revo.demo.entity.Countrty;
import it.revo.demo.repository.CountryRepository;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryRepository countryRepository;
    @GetMapping("/list")
    public List<Countrty> getAllCountries() {
        return countryRepository.findAll();
    }
}
