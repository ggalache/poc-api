package ar.com.galicia.pocapi.domain.user;

import java.util.Collection;

import ar.com.galicia.pocapi.domain.entities.User;
import ar.com.galicia.pocapi.exceptions.UserAlreadyExistsException;
import ar.com.galicia.pocapi.exceptions.UserNotAuthenticatedExeception;
import ar.com.galicia.pocapi.exceptions.UserNotFoundException;

/**
 * Servicio de usuarios.
 * 
 * @author mrsanchez
 */
public interface UserService {

	/**
	 * Loggea el usuario en la aplicación.
	 * 
	 * @param username el nombre de usuario.
	 * @param password el password del usuario.
	 * @return el usuario loggeado.
	 */
	User login(String username, String password);
	
	/**
	 * Busca un usuario en el repositorio.
	 * 
	 * @param username el nombre de usuario.
	 * @return el usuario.
	 */
	User fetchUserByUsername(String username);

	/**
	 * Busca todos los usuarios de la base 
	 * 
	 * @return la lista de usuarios.
	 */
	Collection<User> fetchAll();
	
	/**
	 * Crea un usuario con los datos dados.
	 * 
	 * @param user el usuario.
	 */
	void createUser(User user);
	
	/**
	 * Edita los datos de un usuario particular.
	 * 
	 * @param user el usuario.
	 */
	void editUser(User user);
	
	/**
	 * Elimina el usuario con el nombre de usuario dado.
	 * 
	 * @param username el nombre de usuario.
	 */
	void deleteUserByUsername(String username);
}
