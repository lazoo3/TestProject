package testproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import testproject.model.Avatar;
import testproject.model.User;
import testproject.service.AvatarService;
import testproject.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	AvatarService avatarService;
	
	@RequestMapping(value="/core/user/getUser/", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<User> getListUser(){
		List<User> users = userService.getListUser();
		return users;
	}
	@RequestMapping(value="/core/user/getUserById/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody User getUserById(@PathVariable("id") int id){
		User user = userService.findUserById(id);
		
		return user;
	}
	
	@RequestMapping(value="/core/user/add/", method=RequestMethod.POST)
	public @ResponseBody User add(@RequestBody User user){
		userService.saveOrUpdate(user);
		
		return user;
	}
	
	@RequestMapping(value="/core/user/update/{id}", method=RequestMethod.PUT)
	public @ResponseBody User update(@PathVariable("id") int id, @RequestBody User user){
		user.setId(id);
		
		userService.saveOrUpdate(user);
		
		return user;
	}
	
	@RequestMapping(value="core/user/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody User delete(@PathVariable("id") int id){
		User user = userService.findUserById(id);
		
		userService.deleteUser(id);
		
		return user;
	}
}
