package testproject.dao;

import java.util.List;

import testproject.model.Company;

public interface CompanyDao {
	
	public List<Company> getListCompany();
	
	public void saveOrUpdate(Company company);
	
	public void deleteCompany(int id);
	
	public Company findCompanyById(int id);
}
