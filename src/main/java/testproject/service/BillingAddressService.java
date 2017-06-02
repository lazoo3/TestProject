package testproject.service;

import java.util.List;

import testproject.model.BillingAddress;

public interface BillingAddressService {
	
	public List<BillingAddress> getListBillingAddress();
	
	public void saveOrUpdate(BillingAddress billingAddress);
	
	public void deleteBillingAddress(int id);
	
	public BillingAddress findBillingAddressById(int id);
}
