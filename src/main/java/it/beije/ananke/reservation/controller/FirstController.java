package it.beije.ananke.reservation.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.exception.NoContentException;
import it.beije.ananke.reservation.model.User;

@RestController
//@PreAuthorize("hasAuthority('ADMIN')")
public class FirstController {
	
	protected void verifyLoggedUser(Authentication auth, Integer id) {
		User user = (User) auth.getPrincipal();
		if(id==null)
			throw new NoContentException("IdUser non specificato");
	
		if(!user.getAuthorities().contains("ADMIN") && user.getUserId()!=id)
			throw new NoContentException("Non si possiedono i permessi necessari");
	}
	
}