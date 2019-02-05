package ar.com.galicia.pocapi.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.galicia.pocapi.domain.entities.User;
import ar.com.galicia.pocapi.domain.user.UserService;
import ar.com.galicia.pocapi.exceptions.UserNotFoundException;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(path="{username}", method = RequestMethod.GET)
	public User getUser(@PathVariable("username") String username) {
		try {
			return userService.fetchUserByUsername(username);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
