package it.beije.ananke.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
  
	@Autowired
	private ReservationService reservationService;
}
