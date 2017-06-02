package testproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testproject.model.Avatar;

@Repository
public class AvatarDaoImpl implements AvatarDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Avatar> getListAvatar() {
		Criteria criteria = getSession().createCriteria(Avatar.class);
		return (List<Avatar>) criteria.list();
	}

	@Override
	public void saveOrUpdate(Avatar avatar) {
		getSession().save(avatar);
		
	}

	@Override
	public void deleteAvatar(int id) {
		Avatar avatar = (Avatar) getSession().get(Avatar.class, id);
		getSession().delete(avatar);
		
	}

	@Override
	public Avatar findAvatarById(int id) {
		return (Avatar) getSession().get(Avatar.class, id);
	}

}
