package testproject.dao;

import java.util.List;

import testproject.model.Avatar;

public interface AvatarDao {
	public List<Avatar> getListAvatar();
	
	public void saveOrUpdate(Avatar avatar);
	
	public void deleteAvatar(int id);
	
	public Avatar findAvatarById(int id);
}
