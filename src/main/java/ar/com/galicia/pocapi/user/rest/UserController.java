package ar.com.galicia.pocapi.user.rest;

import java.util.ArrayList;
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
	
	@RequestMapping(value="/users/login", method = RequestMethod.POST)
	public User loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		return userService.login(username, password);
	}

	@RequestMapping(value= "/users", method = RequestMethod.GET)
	public Collection<User> getUsers(@RequestParam(required = false) String username) {
		if(username == null) {
			return userService.fetchAll();
		}
		Collection<User> user = new ArrayList<>();
		user.add(userService.fetchUserByUsername(username));
		return user;
	}
	
	
	@RequestMapping(value="/users", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		userService.createUser(user);
		return userService.fetchUserByUsername(user.getUsername());
	}
	
	@RequestMapping(value="/users/{username}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable String username, @RequestBody User user) {
		user.setUsername(username);
		userService.editUser(user);
		return userService.fetchUserByUsername(user.getUsername());
	}
	
	@RequestMapping(value="/users/{username}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable String username) {
		User user = userService.fetchUserByUsername(username);
		userService.deleteUserByUsername(username);
		return user;
	}
}
