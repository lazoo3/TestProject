package testproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testproject.model.Country;

@Repository
public class CountryDaoImpl implements CountryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getListCountry() {
		Criteria criteria = getSession().createCriteria(Country.class);
		return (List<Country>) criteria.list();
	}

	@Override
	public void saveOrUpdate(Country country) {
		getSession().save(country);
		
	}

	@Override
	public void deleteCountry(int id) {
		Country country = (Country) getSession().get(Country.class, id);
		getSession().delete(country);
		
	}

	@Override
	public Country findCountryById(int id) {
		return (Country) getSession().get(Country.class, id);
	}

}
