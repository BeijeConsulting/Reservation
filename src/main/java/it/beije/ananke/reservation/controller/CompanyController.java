package it.beije.ananke.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.service.AddressService;
import it.beije.ananke.reservation.service.StructureService;
import it.beije.ananke.reservation.service.CompanyService;
import it.beije.ananke.reservation.service.ReservationService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private StructureService buildingService;
	@Autowired
	private AddressService addressService;

}
