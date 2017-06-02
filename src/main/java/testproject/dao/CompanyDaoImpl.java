package testproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testproject.model.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getListCompany() {
		Criteria criteria = getSession().createCriteria(Company.class);
		return (List<Company>) criteria.list();
	}

	@Override
	public void saveOrUpdate(Company company) {
		getSession().save(company);
		
	}

	@Override
	public void deleteCompany(int id) {
		Company company = (Company) getSession().get(Company.class, id);
		getSession().delete(company);
		
	}

	@Override
	public Company findCompanyById(int id) {
		return (Company) getSession().get(Company.class, id);
	}
}
