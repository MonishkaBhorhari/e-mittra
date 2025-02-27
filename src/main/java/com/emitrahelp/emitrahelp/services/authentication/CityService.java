package com.emitrahelp.emitrahelp.services.authentication;

import com.emitrahelp.emitrahelp.entity.City;
import com.emitrahelp.emitrahelp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<City> getCitiesByCountry(String country) {
        return cityRepository.findByCountry(country);
    }

    public List<City> getCitiesByState(String state) {
        return cityRepository.findByState(state);
    }

    public List<City> searchCities(String name) {
        return cityRepository.findByNameContainingIgnoreCase(name);
    }
}
