package testproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testproject.dao.CountryDao;
import testproject.model.Country;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
	CountryDao countryDao;
	
	@Autowired
	public void setAvatarDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	@Override
	public List<Country> getListCountry() {
		return countryDao.getListCountry();
	}

	@Override
	public void saveOrUpdate(Country country) {
		countryDao.saveOrUpdate(country);		
	}

	@Override
	public void deleteCountry(int id) {
		countryDao.deleteCountry(id);		
	}

	@Override
	public Country findCountryById(int id) {
		return countryDao.findCountryById(id);
	}
}
