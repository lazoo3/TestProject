package testproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testproject.model.BillingAddress;

@Repository
public class BillingAddressDaoImpl implements BillingAddressDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BillingAddress> getListBillingAddress() {
		Criteria criteria = getSession().createCriteria(BillingAddress.class);
		return (List<BillingAddress>) criteria.list();
	}

	@Override
	public void saveOrUpdate(BillingAddress billingAddress) {
		getSession().save(billingAddress);
		
	}

	@Override
	public void deleteBillingAddress(int id) {
		BillingAddress billingAddress = (BillingAddress) getSession().get(BillingAddress.class, id);
		getSession().delete(billingAddress);
		
	}

	@Override
	public BillingAddress findBillingAddressById(int id) {
		return (BillingAddress) getSession().get(BillingAddress.class, id);
	}
}
