package ar.com.galicia.pocapi.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.galicia.pocapi.domain.entities.User;

/**
 * Repositorio de usuarios.
 * 
 * @author mrsanchez
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Busca un usaurio por su nombre de usuario.
	 * 
	 * @param username el nombre de usuario.
	 * @return el {@link Optional} de {@link User}.
	 */
	 Optional<User> findByUsername(String username);
}
