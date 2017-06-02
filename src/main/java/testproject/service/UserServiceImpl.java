package testproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testproject.dao.UserDao;
import testproject.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getListUser() {
		return userDao.getListUser();
	}

	@Override
	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);		
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);		
	}

	@Override
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

}
