package com.cognizant.ormlearn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.context.ApplicationContext;

import java.util.List;





@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		//testGetAllCountries();
		//getAllCountriesTest() ;
		testAddCountry();
		testUpdateCountry();

		}
	/*private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries =countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
		}*/
	/*private static void getAllCountriesTest() {

		LOGGER.info("Start");
        try {
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country);
        }
        catch(Exception m) {
        	LOGGER.debug("Exception occured "+m);
        }

		

		LOGGER.info("End");

		}*/
	private static void testAddCountry() {
		Country country=new Country();
		country.setCode("HA");
		country.setName("Harshitha");
		countryService.addCountry(country);
		try {
			Country country1 = countryService.findCountryByCode("HA");
			LOGGER.debug("Country:{}", country1);
	        }
	        catch(Exception m) {
	        	LOGGER.debug("Exception occured "+m);
	        }
		
		
	}
	private static void testUpdateCountry() {
		Country country=countryService.updateCountry("HA", "Haryana.");
		LOGGER.debug("Updated:{}",country);
	}
	

}