package it.beije.ananke.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.model.Services;
import it.beije.ananke.reservation.service.ServicesService;

@RestController
@RequestMapping("/service")
public class ServicesController {

	@Autowired
	private ServicesService servicesService;

	@PreAuthorize("hasAuthority('HOST')")
	@PostMapping("/insertService")
	public Services insertService(@RequestBody Services service) {
		return servicesService.insertServices(service);
	}

	@PreAuthorize("hasAuthority('HOST')")
	@DeleteMapping("/deleteService/{id}")
	public void deleteService(@PathVariable Integer id) {
		servicesService.deleteServices(id);
	}

	@PreAuthorize("hasAuthority('HOST')")
	@GetMapping("/readServiceByBuildingId")
	public void readServiceByBuildingId(@RequestBody Integer id) {
		servicesService.readServicesByStructureId(id);
	}

	@PreAuthorize("hasAuthority('HOST')")
	@GetMapping("/readServiceById/{id}")
	public Services getServicesById(@PathVariable Integer id) {
		return servicesService.readServicesById(id);
	}

	@PreAuthorize("hasAuthority('HOST')")
	@GetMapping("/readServiceByName")
	public List<Services> readServiceByName(@RequestBody String name) {
		return servicesService.readServicesByName(name);
	}

	@PreAuthorize("hasAuthority('HOST')")
	@GetMapping("/readServiceAll")
	public List<Services> readServiceAll() {
		return servicesService.readServicesAll();
	}

	@PreAuthorize("hasAuthority('HOST')")
	@PutMapping("/updateService/{id}")
	public Services updateService(@RequestBody Services service,@PathVariable Integer id) {
		return servicesService.updateServices(service, id);
	}
}
