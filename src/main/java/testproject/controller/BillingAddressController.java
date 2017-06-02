package testproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import testproject.model.BillingAddress;
import testproject.service.BillingAddressService;

@RestController
public class BillingAddressController {
	@Autowired
	BillingAddressService billingAddressService;
	
	@RequestMapping(value="/core/billingAddress/getBillingAddress/", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<BillingAddress> getListAvatar(){
		List<BillingAddress> billingAddresses = billingAddressService.getListBillingAddress();
		
		return billingAddresses;
	}
	
	@RequestMapping(value="/core/billingAddress/add/", method=RequestMethod.POST)
	public @ResponseBody BillingAddress add(@RequestBody BillingAddress billingAddress){
		billingAddressService.saveOrUpdate(billingAddress);
		
		return billingAddress;
	}
	
	@RequestMapping(value="/core/billingAddress/update/{id}", method=RequestMethod.PUT)
	public @ResponseBody BillingAddress update(@PathVariable("id") int id, @RequestBody BillingAddress billingAddress){
		billingAddress.setId(id);
		
		billingAddressService.saveOrUpdate(billingAddress);
		
		return billingAddress;
	}
	
	@RequestMapping(value="/core/billingAddress/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody BillingAddress delete(@PathVariable("id") int id){
		BillingAddress billingAddress = billingAddressService.findBillingAddressById(id);
		
		billingAddressService.deleteBillingAddress(id);
		
		return billingAddress;
	}
}
