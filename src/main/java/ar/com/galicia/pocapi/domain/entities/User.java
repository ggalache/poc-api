package ar.com.galicia.pocapi.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidad que representa un usuario básico.
 * 
 * @author mrsanchez
 */
@Entity
@Table( name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "increment")
    private long id;

    @Column(nullable=false, length=30)
    private String username;

    @Column(nullable=false, length=30)
    private String password;

    @Column (nullable = false)
    private boolean enabled;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "[id:"+this.id+"; username:"+this.username+"; password:"+this.password+"; enable:"+this.enabled+"]";
	}
}
