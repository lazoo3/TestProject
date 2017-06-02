package testproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import testproject.model.Country;
import testproject.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value="/core/country/getCountry/", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<Country> getListCountry(){
		List<Country> countries = countryService.getListCountry();
		
		return countries;
	}
	
	@RequestMapping(value="/core/country/add/", method=RequestMethod.POST)
	public @ResponseBody Country add(@RequestBody Country country){
		countryService.saveOrUpdate(country);
		
		return country;
	}
	
	@RequestMapping(value="/core/country/update/{id}", method=RequestMethod.PUT)
	public @ResponseBody Country update(@PathVariable("id") int id, @RequestBody Country country){
		country.setId(id);
		
		countryService.saveOrUpdate(country);
		
		return country;
	}
	
	@RequestMapping(value="/core/country/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody Country delete(@PathVariable("id") int id){
		Country country = countryService.findCountryById(id);
		
		countryService.deleteCountry(id);
		
		return country;
	}
}
