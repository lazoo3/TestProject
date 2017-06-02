package testproject.dao;

import java.util.List;

import testproject.model.Country;

public interface CountryDao {
	public List<Country> getListCountry();
	
	public void saveOrUpdate(Country country);
	
	public void deleteCountry(int id);
	
	public Country findCountryById(int id);
}
