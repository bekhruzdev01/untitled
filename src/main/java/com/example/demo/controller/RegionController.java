package com.example.demo.controller;

import com.example.demo.entity.Region;
import com.example.demo.service.RegionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

@GetMapping("/by-country/{countryId}")
@ResponseBody
public List<Region> getRegionsByCountry(@PathVariable Long countryId) {
    return regionService.getRegionsByCountryId(countryId);
}
}
