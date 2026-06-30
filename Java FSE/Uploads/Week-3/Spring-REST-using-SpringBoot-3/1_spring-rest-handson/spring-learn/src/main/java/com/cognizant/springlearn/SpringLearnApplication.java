package com.cognizant.springlearn;

import com.cognizant.springlearn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        SpringLearnApplication.class,
                        args
                );

        CountryService service =
                context.getBean(CountryService.class);

        System.out.println(
                service.getCountry()
        );
    }
}