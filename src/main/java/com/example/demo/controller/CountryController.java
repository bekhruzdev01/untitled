package com.example.demo.controller;


import com.example.demo.entity.Country;
import com.example.demo.service.CountryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping()
    public String getCountry(Model model) {
        return "country-list";
    }


    @GetMapping("/list")
@ResponseBody
public List<Country> listCountries() {
    return countryService.getAllCountries();
}

    @GetMapping("/add")
    public String addCountryForm(Model model) {
        model.addAttribute("country", new Country());
        return "country-form";
    }

    @PostMapping("/save")
    @ResponseBody
    public String saveCountry(@RequestBody Country country) {
        countryService.saveCountry(country);
        return "Country saved successfully!";
    }

    @GetMapping("/edit/{id}")
    public String editCountryForm(@PathVariable Long id, Model model) {
        model.addAttribute("country", countryService.getCountryById(id));
        return "country-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return "redirect:/country";
    }

    @GetMapping("/search")
@ResponseBody
public List<Country> searchCountries(@RequestParam String keyword) {
    return countryService.searchCountries(keyword);
}
}
