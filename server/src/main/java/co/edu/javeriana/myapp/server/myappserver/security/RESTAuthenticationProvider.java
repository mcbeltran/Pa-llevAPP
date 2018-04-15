package co.edu.javeriana.myapp.server.myappserver.security;

import co.edu.javeriana.myapp.server.myappserver.model.Empleado;
import co.edu.javeriana.myapp.server.myappserver.model.User;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
public class RESTAuthenticationProvider implements AuthenticationProvider {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RESTUserDetailsService userDetailsService;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		

		User user = userDetailsService.loadUserByUsername(name);
		
		if (user != null && password.equals(user.getPassword())) {
			logger.info("Succesful authentication!");
			return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		} else {
			logger.info("Login fail!");
			return null;
		}
	}
	
	


	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
