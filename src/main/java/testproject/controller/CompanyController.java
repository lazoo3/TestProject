package testproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import testproject.model.Company;
import testproject.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value="/core/company/getCompany/", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<Company> getListCountry(){
		List<Company> companies = companyService.getListCompany();
		
		return companies;
	}
	
	@RequestMapping(value="/core/company/add/", method=RequestMethod.POST)
	public @ResponseBody Company add(@RequestBody Company company){
		companyService.saveOrUpdate(company);
		
		return company;
	}
	
	@RequestMapping(value="/core/company/update/{id}", method=RequestMethod.PUT)
	public @ResponseBody Company update(@PathVariable("id") int id, @RequestBody Company company){
		company.setId(id);
		
		companyService.saveOrUpdate(company);
		
		return company;
	}
	
	@RequestMapping(value="/core/company/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody Company delete(@PathVariable("id") int id){
		Company company = companyService.findCompanyById(id);
		
		companyService.deleteCompany(id);
		
		return company;
	}
}
