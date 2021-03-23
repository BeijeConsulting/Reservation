package it.beije.ananke.reservation.controller;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.beije.ananke.reservation.model.Address;
import it.beije.ananke.reservation.model.Structure;
import it.beije.ananke.reservation.service.AddressService;
import it.beije.ananke.reservation.service.StructureService;

@RestController
@RequestMapping("/structure")
public class StructureController {
	
	@Autowired
	private StructureService structureService;
   
	@Autowired
	private AddressService addressService;
	
	@PreAuthorize("hasAuthority('HOST')")
	@PostMapping("/add")
	public Structure addStructure(@RequestBody Structure structure) {
		Collection<Address> allAddresses = new ArrayList<>();
		allAddresses = structure.getAddresses();
		for(Address address : allAddresses) {
			addressService.insertAddress(address);
		}
		return structureService.addStructure(structure);	
	}
	
	@PreAuthorize("hasAuthority('HOST')")
	@GetMapping("/{id}")
	public Structure getStructure(@PathVariable Integer id) {
		return structureService.getStructure(id);
	}
	
	@PreAuthorize("hasAuthority('HOST')")
	@DeleteMapping("/delete/{id}")
	public void removeStructure(@PathVariable Integer id) {
		structureService.removeStructure(id);
	}

}
