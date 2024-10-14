package org.beta.country_service.controller;

import lombok.RequiredArgsConstructor;
import org.beta.country_service.model.Country;
import org.beta.country_service.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("countries")
public class CountryController {
    private final CountryService countryService;

    //http://localhost:8080/hello
    @GetMapping("hello")
    public String sayHello(){
        return "Hello World";
    }

    //http://localhost:8080/countries
    @GetMapping
    public List<Country> getCountries(){
        return countryService.getCountries();
    }

    @GetMapping("{id}")
    public Country getCountry(@PathVariable String id){
        return countryService.getCountryById(id);
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }

    //http://localhost:8080/countries/{id}
    @DeleteMapping("{id}")
    public Optional<Country> deleteCountry(@PathVariable String id){
        return countryService.deleteCountry(id);
    }
}
