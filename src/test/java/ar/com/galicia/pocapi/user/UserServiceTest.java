package ar.com.galicia.pocapi.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.galicia.pocapi.PocApiApplication;
import ar.com.galicia.pocapi.domain.user.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PocApiApplication.class })
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void injectContextService() throws Exception {
		userService.login("baufest", "baufest2019");
	}
}
