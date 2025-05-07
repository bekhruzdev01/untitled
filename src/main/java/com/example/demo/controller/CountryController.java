package com.example.demo.controller;

import com.example.demo.model.Country;
import com.example.demo.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/list")
    public String listCountries(Model model) {
        model.addAttribute("countries", countryService.getAllCountries());
        return "country-list";
    }

    @GetMapping("/add")
    public String addCountryForm(Model model) {
        model.addAttribute("country", new Country());
        return "country-form";
    }

    @PostMapping("/save")
    public String saveCountry(@ModelAttribute Country country) {
        countryService.saveCountry(country);
        return "redirect:/country/list";
    }

    @GetMapping("/edit/{id}")
    public String editCountryForm(@PathVariable Long id, Model model) {
        model.addAttribute("country", countryService.getCountryById(id));
        return "country-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return "redirect:/country/list";
    }
}
