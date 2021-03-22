package it.beije.ananke.reservation.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
  
	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value="/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getListByUserId(HttpServletRequest req){

		Principal principal = req.getUserPrincipal();
		
		String userEmail = principal.getName();
		
	    return userEmail;
	}
	
}
