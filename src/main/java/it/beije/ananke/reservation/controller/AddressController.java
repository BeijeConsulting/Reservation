package it.beije.ananke.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.model.Address;
import it.beije.ananke.reservation.service.AddressService;
import it.beije.ananke.reservation.service.ReservationService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	 @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	  public void insertAddress(@RequestBody Address address) {
		addressService.insertAddress(address);
	}
	 @PutMapping("/newAddress/{id}")
	  Address updateAddress(@RequestBody Address newAddress, @PathVariable Integer id) {
		 return addressService.updateAddress(newAddress, id);
	 }
	 
	 @DeleteMapping("{id}")
	  void deleteAddress(@PathVariable Integer addressId) {
	    addressService.deleteAddress(addressId);
	  }

}
