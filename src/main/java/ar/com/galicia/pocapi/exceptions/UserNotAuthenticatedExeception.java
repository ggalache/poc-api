package ar.com.galicia.pocapi.exceptions;

/**
 * Excepción para cuando un usuario no esta loggeado.
 * 
 * @author mrsanchez
 */
public class UserNotAuthenticatedExeception extends Exception {

	private static final long serialVersionUID = 1942298648585808185L;

	public UserNotAuthenticatedExeception(String username) {
		super("Error al autenticar el usuario: "+ username);
	}
}
