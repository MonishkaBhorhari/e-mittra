package com.emitrahelp.emitrahelp.repository;

import com.emitrahelp.emitrahelp.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByCountry(String country);
    List<City> findByState(String state);
    List<City> findByNameContainingIgnoreCase(String name);

    City findByName(String cityName);
}