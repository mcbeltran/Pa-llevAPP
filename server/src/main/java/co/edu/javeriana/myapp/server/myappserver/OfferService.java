package co.edu.javeriana.myapp.server.myappserver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.myapp.server.myappserver.model.Offer;
import co.edu.javeriana.myapp.server.myappserver.model.OfferRepository;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:4200")
public class OfferService {
	
	@Autowired
	private OfferRepository repository;
	
	@RequestMapping("/offers")
	Iterable<Offer> findAll(){
		return repository.findAll();
	}
	
	@RequestMapping("/offers/{university}")
	List<Offer> find(@PathVariable("university") Long university) {
		return repository.findByUniversity(university);
	}

}
