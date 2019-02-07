package ar.com.galicia.pocapi.user.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.galicia.pocapi.domain.entities.User;
import ar.com.galicia.pocapi.domain.user.UserService;
import ar.com.galicia.pocapi.exceptions.UserAlreadyExistsException;
import ar.com.galicia.pocapi.exceptions.UserNotAuthenticatedExeception;
import ar.com.galicia.pocapi.exceptions.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/{username}", method = RequestMethod.GET)
	public User getUser(@PathVariable("username") String username) {
		try {
			return userService.fetchUserByUsername(username);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public User loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		try {
			return userService.login(username, password);
		} catch (UserNotAuthenticatedExeception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/user/list", method = RequestMethod.GET)
	public Collection<User> getUsers() {
			return userService.fetchAll();
	}
	
	@RequestMapping(value="/user/create", method = RequestMethod.POST)
	public User createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		try {
			userService.createUser(user);
			return userService.fetchUserByUsername(username);
		} catch (UserAlreadyExistsException|UserNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/user/update", method = RequestMethod.PUT)
	public User updateUser(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("enabled") Boolean enabled) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEnabled(enabled);
		try {
			userService.editUser(user);
			return userService.fetchUserByUsername(username);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/user/delete", method = RequestMethod.DELETE)
	public User deleteUser(@RequestParam("username") String username) {
		try {
			User user = userService.fetchUserByUsername(username);
			userService.deleteUserByUsername(username);
			return user;
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
