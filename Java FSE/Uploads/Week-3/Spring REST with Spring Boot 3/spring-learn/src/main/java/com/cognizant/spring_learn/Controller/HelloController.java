package com.cognizant.spring_learn.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.Service.CountryService;

@RestController
@RequestMapping("/")
public class HelloController {
	
	@Autowired
	private CountryService countryService;

		@GetMapping("/hello")
		public String sayHello() {
			System.out.println("Start");
			return "Hello World! - Mohan Sarady";
		}
		
		@GetMapping("/country")
		public Country getCountryIndia() {
			ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
			  Country country = context.getBean("india", Country.class);
			return country;
		}
		
		@GetMapping("/all")
		public List<Country> getAllCountries() {
		    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		   
		    Map<String, Country> countryMap = context.getBeansOfType(Country.class);
		    
		    List<Country> countryList = new ArrayList<>(countryMap.values());
		    
		    return countryList;
		}
		@GetMapping("/countries/{code}")
	    public Country getCountry(@PathVariable String code) {
	        return countryService.getCountry(code);
	    }
}

