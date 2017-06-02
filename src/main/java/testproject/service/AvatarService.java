package testproject.service;

import java.util.List;

import testproject.model.Avatar;

public interface AvatarService {
	public List<Avatar> getListAvatar();
	
	public void saveOrUpdate(Avatar avatar);
	
	public void deleteAvatar(int id);
	
	public Avatar findAvatarById(int id);
}
