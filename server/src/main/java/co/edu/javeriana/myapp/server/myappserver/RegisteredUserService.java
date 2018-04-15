package co.edu.javeriana.myapp.server.myappserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.myapp.server.myappserver.model.Empleado;
import co.edu.javeriana.myapp.server.myappserver.model.RegisteredUser;
import co.edu.javeriana.myapp.server.myappserver.model.RegisteredUserRepository;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:4200")
public class RegisteredUserService {
	
	@Autowired
	private RegisteredUserRepository repository;
	
	@RequestMapping("/students")
	Iterable<RegisteredUser> findAll() {
		return repository.findAll();
	}
	
	public RegisteredUser findByUsername(String username) {
		return repository.findByUsername(username);
	}

}
