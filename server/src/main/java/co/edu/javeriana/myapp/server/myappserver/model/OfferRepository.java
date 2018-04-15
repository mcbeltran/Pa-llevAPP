package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Offer, Long> {
	
	@Query(value = "SELECT * FROM offer e WHERE (branch_id = ?1)", nativeQuery = true)
	public List<Offer> findByUniversity(Long university);

}
