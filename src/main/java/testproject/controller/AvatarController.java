package testproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import testproject.model.Avatar;
import testproject.service.AvatarService;

@RestController
public class AvatarController {
	@Autowired
	AvatarService avatarService;
	
	@RequestMapping(value="/core/avatar/getAvatar/", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<Avatar> getListAvatar(){
		List<Avatar> avatars = avatarService.getListAvatar();
		
		return avatars;
	}
	
	@RequestMapping(value="/core/avatar/add/", method=RequestMethod.POST)
	public @ResponseBody Avatar add(@RequestBody Avatar avatar){
		avatarService.saveOrUpdate(avatar);
		
		return avatar;
	}
	
	@RequestMapping(value="/core/avatar/update/{id}", method=RequestMethod.PUT)
	public @ResponseBody Avatar update(@PathVariable("id") int id, @RequestBody Avatar avatar){
		avatar.setId(id);
		
		avatarService.saveOrUpdate(avatar);
		
		return avatar;
	}
	
	@RequestMapping(value="/core/avatar/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody Avatar delete(@PathVariable("id") int id){
		Avatar avatar = avatarService.findAvatarById(id);
		
		avatarService.deleteAvatar(id);
		
		return avatar;
	}
}
