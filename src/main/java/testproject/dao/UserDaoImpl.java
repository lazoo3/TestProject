package testproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testproject.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	@Override
	public void saveOrUpdate(User user) {
		getSession().save(user);
		
	}

	@Override
	public void deleteUser(int id) {
		User user = (User) getSession().get(User.class, id);
		getSession().delete(user);
		
	}

	@Override
	public User findUserById(int id) {
		return (User) getSession().get(User.class, id);
	}

}
