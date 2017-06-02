package testproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testproject.dao.CompanyDao;
import testproject.model.Company;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{
	CompanyDao companyDao;
	
	@Autowired
	public void setAvatarDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public List<Company> getListCompany() {
		return companyDao.getListCompany();
	}

	@Override
	public void saveOrUpdate(Company company) {
		companyDao.saveOrUpdate(company);		
	}

	@Override
	public void deleteCompany(int id) {
		companyDao.deleteCompany(id);		
	}

	@Override
	public Company findCompanyById(int id) {
		return companyDao.findCompanyById(id);
	}
}
