package testproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testproject.dao.BillingAddressDao;
import testproject.model.BillingAddress;


@Service
@Transactional
public class BillingAddressServiceImpl implements BillingAddressService{
	BillingAddressDao billingAddressDao;
	
	@Autowired
	public void setAvatarDao(BillingAddressDao billingAddressDao) {
		this.billingAddressDao = billingAddressDao;
	}

	@Override
	public List<BillingAddress> getListBillingAddress() {
		return billingAddressDao.getListBillingAddress();
	}

	@Override
	public void saveOrUpdate(BillingAddress billingAddress) {
		billingAddressDao.saveOrUpdate(billingAddress);		
	}

	@Override
	public void deleteBillingAddress(int id) {
		billingAddressDao.deleteBillingAddress(id);		
	}

	@Override
	public BillingAddress findBillingAddressById(int id) {
		return billingAddressDao.findBillingAddressById(id);
	}
}
