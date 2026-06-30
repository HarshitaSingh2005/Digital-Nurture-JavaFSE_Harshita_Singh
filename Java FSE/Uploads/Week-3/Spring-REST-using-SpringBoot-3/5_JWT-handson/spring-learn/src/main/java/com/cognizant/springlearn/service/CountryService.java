package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public Country getCountry(String code) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        String[] beanNames =
                {"country1", "country2", "country3"};

        for (String beanName : beanNames) {

            Country country =
                    context.getBean(beanName, Country.class);

            if (country.getCode()
                    .equalsIgnoreCase(code)) {

                return country;
            }
        }

        return null;
    }
}