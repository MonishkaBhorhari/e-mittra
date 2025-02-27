package com.emitrahelp.emitrahelp.controller;

import com.emitrahelp.emitrahelp.entity.City;
import com.emitrahelp.emitrahelp.services.authentication.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@CrossOrigin(origins = "http://localhost:5500")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getCities(@RequestParam(required = false) String country,
                                @RequestParam(required = false) String state,
                                @RequestParam(required = false) String search) {
        if (search != null) {
            return cityService.searchCities(search);
        } else if (country != null) {
            return cityService.getCitiesByCountry(country);
        } else if (state != null) {
            return cityService.getCitiesByState(state);
        } else {
            return cityService.getAllCities();
        }
    }
}