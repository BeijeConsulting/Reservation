package it.beije.ananke.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	 @GetMapping("/userAddress/{id}")
	  public Address getAddressByUserId(@PathVariable Integer id) {
		return addressService.findByUserId(id);
	}
	 @GetMapping("/companyAddress/{id}")
	  public Address getAddressByCompanyId(@PathVariable Integer id) {
		return addressService.findByCompanyId(id);
	}
	 @GetMapping("/structureAddress/{id}")
	  public Address getAddressByStructureId(@PathVariable Integer id) {
		return addressService.findByStructureId(id);
	}
	
	 @PostMapping("/add")
	  public void insertAddress(@RequestBody Address address) {
		addressService.insertAddress(address);
	}
	 @PutMapping("/{id}")
	  Address updateAddress(@RequestBody Address newAddress, @PathVariable Integer id) {
		 return addressService.updateAddress(newAddress, id);
	 }
	 
	 @DeleteMapping("/{id}")
	  void deleteAddress(@PathVariable Integer id) {
	    addressService.deleteAddress(id);
	  }

}
