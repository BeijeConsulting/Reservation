package it.beije.ananke.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.model.Address;
import it.beije.ananke.reservation.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PreAuthorize("hasAuthority('HOST')")
	 @GetMapping("/userAddress/{id}")
	  public Address getAddressByUserId(@PathVariable Integer id) {
		return addressService.findByUserId(id);
	}
	
	@PreAuthorize("hasAuthority('HOST')")
	 @GetMapping("/companyAddress/{id}")
	  public Address getAddressByCompanyId(@PathVariable Integer id) {
		return addressService.findByCompanyId(id);
	}
	
	@PreAuthorize("hasAuthority('HOST')")
	 @GetMapping("/structureAddress/{id}")
	  public Address getAddressByStructureId(@PathVariable Integer id) {
		return addressService.findByStructureId(id);
	}
	
	@PreAuthorize("hasAuthority('HOST')")
	 @PostMapping("/add")
	  public void insertAddress(@RequestBody Address address) {
		addressService.insertAddress(address);
	}
	
	@PreAuthorize("hasAuthority('HOST')")
	 @PutMapping("/{id}")
	  Address updateAddress(@RequestBody Address newAddress, @PathVariable Integer id) {
		 return addressService.updateAddress(newAddress, id);
	 }
	 
	@PreAuthorize("hasAuthority('HOST')")
	 @DeleteMapping("/delete/{id}")
	  void deleteAddress(@PathVariable Integer id) {
	    addressService.deleteAddress(id);
	  }

}
