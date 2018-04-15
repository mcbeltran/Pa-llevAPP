package co.edu.javeriana.myapp.server.myappserver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.myapp.server.myappserver.model.UniversityRepository;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:4200")
public class UniversityService {

	@Autowired
	private UniversityRepository repository;

	@RequestMapping(value = "/universities", method = RequestMethod.GET)
	public List<String> getUniversities() {
		return repository.getUniversityNames();
	}

}
