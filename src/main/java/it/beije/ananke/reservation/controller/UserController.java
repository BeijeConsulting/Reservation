package it.beije.ananke.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.service.AuthorityService;
import it.beije.ananke.reservation.service.CompanyService;
import it.beije.ananke.reservation.service.ReservationService;
import it.beije.ananke.reservation.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private CompanyService companyService;

	@GetMapping("/a")
	public String login() {


		return "view/login.jsp";
	}

}
