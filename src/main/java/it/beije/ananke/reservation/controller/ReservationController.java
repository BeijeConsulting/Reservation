package it.beije.ananke.reservation.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@GetMapping("/test")
	public String getCurrentUser(HttpServletRequest req){
		
		Principal principal = req.getUserPrincipal();
		
		String userEmail = principal.getName();
		
	    return userEmail;
	    
	}
	
	@PreAuthorize("hasAuthority('CUSTOMER')")
	@GetMapping("/{reservationId}")
	public Reservation getReservationById(@PathVariable Integer reservationId) {
		
		return reservationService.findByReservationId(reservationId);
		
	}
	
	@PreAuthorize("hasAuthority('CUSTOMER')")
	@GetMapping("/list")
	public List<Reservation> getMyReservationList(HttpServletRequest req){
		
		Integer id = userService.findUserByUserEmail(req);
		
	    List<Reservation> prenotazioni = reservationService.findByUserId(id);
	    
	    return prenotazioni;
	    
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/all")
	public List<Reservation> getAllReservationList(HttpServletRequest req){

	    List<Reservation> prenotazioni = reservationService.findAll();
	    
	    return prenotazioni;
	    
	}
	
	@PreAuthorize("hasAuthority('CUSTOMER')")
	@PostMapping("/new/{serviceId}")
	public Reservation newReservation(@RequestBody Reservation reservation, @PathVariable Integer serviceId, HttpServletRequest req) {
		
		return reservationService.newReservation(reservation, req, serviceId);
		
	}
	
	@PreAuthorize("hasAuthority('CUSTOMER')")
	@DeleteMapping("/delete/{reservationId}")
	public void deleteReservation(@PathVariable Integer reservationId) {
		
		reservationService.deleteReservation(reservationId);
		
	}
	
	@PreAuthorize("hasAuthority('CUSTOMER')")
	@DeleteMapping("/update/{reservationId}")
	public Reservation updateReservation(@PathVariable Integer reservationId, @RequestBody Reservation reservation) {
		
		return reservationService.updateReservation(reservation, reservationId);
		
	}
	
}
