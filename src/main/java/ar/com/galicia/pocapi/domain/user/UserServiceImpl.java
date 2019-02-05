package ar.com.galicia.pocapi.domain.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.galicia.pocapi.domain.entities.User;
import ar.com.galicia.pocapi.exceptions.UserNotAuthenticatedExeception;
import ar.com.galicia.pocapi.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepositoy;
	
    @Override
    public User login(String username, String password) throws UserNotAuthenticatedExeception {
        Optional<User> optUser =userRepositoy.findByUsername(username);
        if (optUser.isPresent() && isUserValid(password, optUser)){
            return optUser.get();
        }
        throw new UserNotAuthenticatedExeception(username);
    }

    private boolean isUserValid(String password, Optional<User> optUser) {
        return optUser.get().isEnabled() && optUser.get().getPassword().equals(password);
    }

	@Override
	public User fetchUserByUsername(String username) throws UserNotFoundException {
		Optional<User> optUser =userRepositoy.findByUsername(username);
        if (optUser.isPresent()){
            return optUser.get();
        }
        throw new UserNotFoundException(username);
	}

}
