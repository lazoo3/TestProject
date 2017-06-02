package testproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import testproject.model.Avatar;
import testproject.model.BillingAddress;
import testproject.model.Company;
import testproject.model.Country;
import testproject.model.User;
import testproject.service.AvatarService;
import testproject.service.BillingAddressService;
import testproject.service.CompanyService;
import testproject.service.CountryService;
import testproject.service.UserService;

@RestController
public class HomeController {
	@Autowired
	UserService userService;
	
	@Autowired
	AvatarService avatarService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	BillingAddressService billingAddressService;
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value="/core/home/getUserById/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<Object> getUserById(@PathVariable("id") int id){
		List<Object> users = new ArrayList<>();
		User user = userService.findUserById(id);
		Avatar avatar = avatarService.findAvatarById(user.getAvatarId());
		Company company = companyService.findCompanyById(user.getCompanyId());
		BillingAddress billingAddress = billingAddressService.findBillingAddressById(company.getBillingId());
		Country country = countryService.findCountryById(billingAddress.getCountryId());
		
		users.add(user);
		users.add(avatar);
		users.add(company);
		users.add(billingAddress);
		users.add(country);
		return users;
	}
}
