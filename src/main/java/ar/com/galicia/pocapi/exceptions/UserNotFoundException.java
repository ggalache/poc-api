package ar.com.galicia.pocapi.exceptions;

/**
 * Excepción cuando no existe el usuario.
 * 
 * @author mrsanchez
 */
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -8718868782771306239L;

	public UserNotFoundException(String username) {
		super("No se encuentra el usuario: "+ username);
	}
}
