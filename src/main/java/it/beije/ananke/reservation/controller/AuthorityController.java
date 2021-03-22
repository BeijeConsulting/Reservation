package it.beije.ananke.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.service.AuthorityService;

@RestController
@RequestMapping("/authority")
public class AuthorityController {

	
	@Autowired
	private AuthorityService authorityService;
}
