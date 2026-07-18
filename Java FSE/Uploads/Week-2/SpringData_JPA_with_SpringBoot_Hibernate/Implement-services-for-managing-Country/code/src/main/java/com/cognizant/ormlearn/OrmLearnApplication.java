package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(
                    OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        OrmLearnApplication.class,
                        args
                );

        countryService =
                context.getBean(CountryService.class);

        LOGGER.info("Inside main");

//        testGetAllCountries();
//        testGetCountry();
//        testAddCountry();
//        testUpdateCountry();
//        testSearchCountry();
//        testDeleteCountry();
    }

    private static void testGetCountry() {

        LOGGER.info("Start");

        Country country =
                countryService.getCountry("IN");

        LOGGER.debug("country={}", country);

        LOGGER.info("End");
    }
    private static void testAddCountry() {

        Country country = new Country();

        country.setCode("FR");
        country.setName("France");

        countryService.addCountry(country);

        LOGGER.info("Country Added");
    }
    private static void testUpdateCountry() {

        Country country =
                countryService.getCountry("IN");

        country.setName("Bharat");

        countryService.updateCountry(country);

        LOGGER.info("Country Updated");
    }
    private static void testDeleteCountry() {

        countryService.deleteCountry("FR");

        LOGGER.info("Country Deleted");
    }
    private static void testSearchCountry() {

        LOGGER.info("Start");

        List<Country> countries =
                countryService.searchCountry("Uni");

        LOGGER.debug("countries={}", countries);

        LOGGER.info("End");
    }

    private static void testGetAllCountries() {

        LOGGER.info("Start");

        List<Country> countries =
                countryService.getAllCountries();

        LOGGER.debug("countries={}", countries);

        LOGGER.info("End");
    }

}