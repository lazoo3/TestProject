package testproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testproject.dao.AvatarDao;
import testproject.model.Avatar;

@Service
@Transactional
public class AvatarServiceImpl implements AvatarService{
	AvatarDao avatarDao;
	
	@Autowired
	public void setAvatarDao(AvatarDao avatarDao) {
		this.avatarDao = avatarDao;
	}

	@Override
	public List<Avatar> getListAvatar() {
		return avatarDao.getListAvatar();
	}

	@Override
	public void saveOrUpdate(Avatar avatar) {
		avatarDao.saveOrUpdate(avatar);		
	}

	@Override
	public void deleteAvatar(int id) {
		avatarDao.deleteAvatar(id);		
	}

	@Override
	public Avatar findAvatarById(int id) {
		return avatarDao.findAvatarById(id);
	}

}
