package ar.com.galicia.pocapi.exceptions;

/**
 * Excepcion para cuando un usuario esta deshabilitado.
 * 
 * @author mrsanchez
 */
public class UserDisabledException extends RuntimeException {

	private static final long serialVersionUID = 4396996362659278159L;

	public UserDisabledException(String username) {
		super("El usuario " + username + " se encuentra deshabilitado.");
	}
}
