package it.beije.ananke.reservation.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.model.Reservation;
import it.beije.ananke.reservation.service.ReservationService;
import it.beije.ananke.reservation.service.UserService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
  
	@Autowired
	private UserService userService;
	@Autowired
	private ReservationService reservationService;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getCurrentUser(HttpServletRequest req){
		
		Principal principal = req.getUserPrincipal();
		
		String userEmail = principal.getName();
		
	    return userEmail;
	    
	}
	
	@PreAuthorize("hasAuthority('CUSTOMER')")
	@RequestMapping(value="/list", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Reservation> getReservationList(HttpServletRequest req){
		
		Integer id = userService.findUserByUserEmail(req);
		
	    List<Reservation> prenotazioni = reservationService.findByUserId(id);
	    
	    return prenotazioni;
	    
	}
	
}
