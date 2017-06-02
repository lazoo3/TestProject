package testproject.service;

import java.util.List;

import testproject.model.Company;

public interface CompanyService {
	public List<Company> getListCompany();
	
	public void saveOrUpdate(Company company);
	
	public void deleteCompany(int id);
	
	public Company findCompanyById(int id);
}
