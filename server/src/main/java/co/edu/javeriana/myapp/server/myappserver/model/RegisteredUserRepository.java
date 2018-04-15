package co.edu.javeriana.myapp.server.myappserver.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RegisteredUserRepository extends CrudRepository<RegisteredUser, Long> {
	
	@Query(value = "SELECT * FROM registered_user e WHERE (username = ?1)", nativeQuery = true)
	public RegisteredUser findByUsername(String username);

}
