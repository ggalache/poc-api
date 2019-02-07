package ar.com.galicia.pocapi.user.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.galicia.pocapi.domain.entities.User;
import ar.com.galicia.pocapi.domain.user.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/{username}", method = RequestMethod.GET)
	public User getUser(@PathVariable("username") String username) {
		return userService.fetchUserByUsername(username);
	}
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public User loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		return userService.login(username, password);
	}
	
	@RequestMapping(value="/user/list", method = RequestMethod.GET)
	public Collection<User> getUsers() {
		return userService.fetchAll();
	}
	
	@RequestMapping(value="/user/create", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		userService.createUser(user);
		return userService.fetchUserByUsername(user.getUsername());
	}
	
	@RequestMapping(value="/user/update", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		userService.editUser(user);
		return userService.fetchUserByUsername(user.getUsername());
	}
	
	@RequestMapping(value="/user/delete/{username}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable("username") String username) {
		User user = userService.fetchUserByUsername(username);
		userService.deleteUserByUsername(username);
		return user;
	}
}
