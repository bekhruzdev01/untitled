package it.revo.demo.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {
    
    @GetMapping("/list")
    public List<Countrty> getAllCountries() {
        return CountryRepository.findAll();
    }
}
