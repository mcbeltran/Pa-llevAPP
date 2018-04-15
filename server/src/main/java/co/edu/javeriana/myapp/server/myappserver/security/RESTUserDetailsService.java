package co.edu.javeriana.myapp.server.myappserver.security;

import co.edu.javeriana.myapp.server.myappserver.EmpleadoService;
import co.edu.javeriana.myapp.server.myappserver.RegisteredUserService;
import co.edu.javeriana.myapp.server.myappserver.model.Empleado;
import co.edu.javeriana.myapp.server.myappserver.model.EmpleadoRepository;
import co.edu.javeriana.myapp.server.myappserver.model.RegisteredUser;
import co.edu.javeriana.myapp.server.myappserver.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.id.CompositeNestedGeneratedValueGenerator.GenerationContextLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class RESTUserDetailsService implements UserDetailsService {
	
	@Autowired
	private RegisteredUserService registeredUserService;
	Map<String, User> users = new HashMap<>();

	public RESTUserDetailsService() {
		super();
	}
	
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO En este método debería recuperarlse la info del usuario desde la base de datos
		
//		System.out.println("*** Retrieving user");
		RegisteredUser user = null;
		User newUser = null;
		
		if( !users.containsKey(username) ) {
			//EmpleadoService es = new EmpleadoService();
			
			user = registeredUserService.findByUsername(username);
			
//			System.out.println(e.getUsername() + " " + e.getPassword() + " " + e.getId() + " " + e.getRol().toString() );
			
			if( user != null ) {
				newUser = new User( user.getUsername(), user.getPassword(), user.getInstitution().getName(), user.getRole(), user.getRole().toString() );
				users.put(user.getUsername(), newUser);
				
			}
			
		} else {
			newUser = users.get(username);
		}
		
		
		return ( newUser );
	}	

}
