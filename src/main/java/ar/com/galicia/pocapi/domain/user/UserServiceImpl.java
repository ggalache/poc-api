package ar.com.galicia.pocapi.domain.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.galicia.pocapi.domain.entities.User;
import ar.com.galicia.pocapi.exceptions.UserAlreadyExistsException;
import ar.com.galicia.pocapi.exceptions.UserDisabledException;
import ar.com.galicia.pocapi.exceptions.UserNotAuthenticatedExeception;
import ar.com.galicia.pocapi.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepositoy;
	
    @Override
    public User login(String username, String password) {
        Optional<User> optUser =userRepositoy.findByUsername(username);
        if(!optUser.isPresent()) {
        	throw new UserNotFoundException(username);
        }
        if(!isUserValid(password, optUser)) {
        	throw new UserNotAuthenticatedExeception(username);
        }
        if(!optUser.get().isEnabled()) {
        	throw new UserDisabledException(username);
        }
        return optUser.get();
    }

    private boolean isUserValid(String password, Optional<User> optUser) {
        return optUser.get().isEnabled() && optUser.get().getPassword().equals(password);
    }

	@Override
	public User fetchUserByUsername(String username) {
		Optional<User> optUser =userRepositoy.findByUsername(username);
        if (optUser.isPresent()){
            return optUser.get();
        }
        throw new UserNotFoundException(username);
	}

	@Override
	public Collection<User> fetchAll() {
		return userRepositoy.findAll();
	}

	@Override
	public void createUser(User user) {
		Optional<User> optUser =userRepositoy.findByUsername(user.getUsername());
        if (optUser.isPresent()){
        	throw new UserAlreadyExistsException(user.getUsername());
        }
        user.setEnabled(true);
		userRepositoy.save(user);
	}

	@Override
	public void editUser(User user) {
		Optional<User> optUser =userRepositoy.findByUsername(user.getUsername());
        if (!optUser.isPresent()){
        	throw new UserNotFoundException(user.getUsername());
        }
        User userEdit = optUser.get();
        userEdit.setUsername(user.getUsername());
        userEdit.setPassword(user.getPassword());
        userEdit.setEnabled(user.isEnabled());
        
		userRepositoy.save(userEdit);
	}

	@Override
	public void deleteUserByUsername(String username) {
		Optional<User> optUser =userRepositoy.findByUsername(username);
        if (!optUser.isPresent()){
        	throw new UserNotFoundException(username);
        }
        userRepositoy.delete(optUser.get());
	}

}
