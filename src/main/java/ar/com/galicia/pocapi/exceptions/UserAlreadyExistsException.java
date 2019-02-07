package ar.com.galicia.pocapi.exceptions;

/**
 * Excepción para cuando un usuario ya existe.
 * 
 * @author mrsanchez
 */
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -2517254186634600230L;

	public UserAlreadyExistsException(String username) {
		super("Ya existe el usuario con el username: " + username);
	}
}
