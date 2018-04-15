package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, Long> {
	
	@Query(value = "SELECT name FROM university", nativeQuery = true)
	public List<String> getUniversityNames();

}
