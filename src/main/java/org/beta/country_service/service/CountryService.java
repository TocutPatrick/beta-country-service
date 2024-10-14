package org.beta.country_service.service;

import org.beta.country_service.model.Country;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryService {
    private List<Country> countries = new ArrayList<>();

    public void setCountries(List<Country> countries) {
        this.countries.addAll(countries);
    }

    public List<Country> getCountries() {
        return countries;
    }

    public Country addCountry(Country country){
        Country newCountryWithId = country.withId(UUID.randomUUID().toString());
        countries.add(newCountryWithId);
        return newCountryWithId;
    }

    public Optional<Country> deleteCountry(String id){
        Optional<Country> countryToBeDeleted = Optional.ofNullable(getCountryById(id));
        countries.remove(countryToBeDeleted);
        return countryToBeDeleted;
    }

    public Country getCountryById(String id) {
        return countries.stream()
                .filter(country -> country.id().equalsIgnoreCase(country.id()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }
}

