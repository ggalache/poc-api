package ar.com.galicia.pocapi.user;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.galicia.pocapi.PocApiApplication;
import ar.com.galicia.pocapi.domain.entities.User;
import ar.com.galicia.pocapi.domain.user.UserService;
import ar.com.galicia.pocapi.exceptions.UserDisabledException;
import ar.com.galicia.pocapi.exceptions.UserNotAuthenticatedExeception;
import ar.com.galicia.pocapi.exceptions.UserNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PocApiApplication.class })
public class UserServiceTest {

	private static final String USER_NOT_FOUND = "usuarioInexistente";
	
	private static final String USER_TEST_1 = "mauricio";
	private static final String USER_PASS_TEST_1 = "mauricio123";
	private static final String USER_PASS_INCORRECT_TEST_1 = "contraseñaIncorrecta";
	
	private static final String USER_TEST_EDIT_LOGIN = "victor";
	private static final String USER_PASS_EDIT_LOGIN = "victor123";
	private static final String USER_PASS_EDIT_LOGIN_EDIT = "victor";
	
	private static final String USER_CREATE = "maximiliano";
	private static final String USER_PASS_CREATE = "maximiliano123";
	
	private static final String USER_FETCH = "guillermina";
	private static final String USER_PASS_FETCH = "guillermina123";
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testLogin() throws Exception {
		User user = userService.login(USER_TEST_1, USER_PASS_TEST_1);
		assertEquals(user.getUsername(), USER_TEST_1);
	}
	
	@Test(expected = UserNotAuthenticatedExeception.class)
	public void testLoginErrorAuthenticated() throws Exception {
		userService.login(USER_TEST_1, USER_PASS_INCORRECT_TEST_1);
	}
	
	@Test(expected = UserDisabledException.class)
	public void testDisabledAndLoginUser() throws Exception {
		User user = new User();
		user.setUsername(USER_TEST_EDIT_LOGIN);
		user.setPassword(USER_PASS_EDIT_LOGIN);
		user.setEnabled(false);
		
		userService.editUser(user);
		userService.login(USER_TEST_EDIT_LOGIN, USER_PASS_EDIT_LOGIN);
	}
	
	@Test
	public void testEditUser() throws Exception {
		User user = new User();
		user.setUsername(USER_TEST_EDIT_LOGIN);
		user.setPassword(USER_PASS_EDIT_LOGIN_EDIT);
		user.setEnabled(false);
		
		userService.editUser(user);
		User userEdit = userService.fetchUserByUsername(USER_TEST_EDIT_LOGIN);
		
		assertEquals(userEdit.getPassword(), USER_PASS_EDIT_LOGIN_EDIT);
		assertEquals(userEdit.isEnabled(), false);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testEditUserNotFound() throws Exception {
		User user = new User();
		user.setUsername(USER_NOT_FOUND);
		userService.editUser(user);
	}
	
	@Test
	public void testFetchAllUsers() throws Exception {
		Collection<User> users = userService.fetchAll();
		assertEquals(7, users.size());
	}
	
	@Test 
	public void testCreateAndDeleteUser() throws Exception {
		User user = new User();
		user.setUsername(USER_CREATE);
		user.setPassword(USER_PASS_CREATE);
		user.setEnabled(true);
		userService.createUser(user);
		assertEquals(8, userService.fetchAll().size());
		
		userService.deleteUserByUsername(USER_CREATE);
		assertEquals(7, userService.fetchAll().size());
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testDeleteUserNotFound() throws Exception {
		userService.deleteUserByUsername(USER_NOT_FOUND);
	}
	
	@Test
	public void testFetchUserByUsername() throws Exception {
		User user = userService.fetchUserByUsername(USER_FETCH);
		
		assertEquals(user.getUsername(), USER_FETCH);
		assertEquals(user.getPassword(), USER_PASS_FETCH);
		assertEquals(user.isEnabled(), true);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testFetchUserNotFoundByUsername() throws Exception {
		userService.fetchUserByUsername(USER_NOT_FOUND);
	}
}