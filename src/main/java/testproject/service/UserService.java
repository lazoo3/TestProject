package testproject.service;

import java.util.List;

import testproject.model.User;

public interface UserService {
	
	public List<User> getListUser();
	
	public void saveOrUpdate(User user);
	
	public void deleteUser(int id);
	
	public User findUserById(int id);
}
