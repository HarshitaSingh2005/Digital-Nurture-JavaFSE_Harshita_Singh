package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Country getCountry(String code) {

        return repository
                .findById(code)
                .orElse(null);
    }

    @Transactional
    public Country addCountry(Country country) {

        return repository.save(country);
    }

    @Transactional
    public Country updateCountry(Country country) {

        return repository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {

        repository.deleteById(code);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountry(String text) {

        return repository
                .findByNameContainingIgnoreCase(text);
    }
}