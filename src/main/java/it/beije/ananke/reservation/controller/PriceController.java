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

import it.beije.ananke.reservation.model.Price;
import it.beije.ananke.reservation.service.PriceService;


@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@PreAuthorize("hasAuthority('CUSTOMER')")
	@GetMapping("/prices")
	public List<Price> getAllPrices(){
		
		List<Price> prices = priceService.findAll();
		
		return prices;
	}
	
	
	@PreAuthorize("hasAuthority('HOST')")
	@GetMapping("/typeofprice/{id}")
	public String getPriceTypeName(@PathVariable Integer id) {
		
		String priceTypeName = priceService.findPriceTypeNameById(id);
		
		return priceTypeName;
	}
	
	
	@PreAuthorize("hasAuthority('HOST')")
	@GetMapping("/pricebyservice/{id}")
	public List<Price> getAllByService(@PathVariable Integer id) {
		
	List<Price> prices = priceService.findAllByServicesId(id);
		
		return prices;
	}
	
	
	@PreAuthorize("hasAuthority('HOST')")
	@PutMapping("/updateprice/{id}/{amount}")
	public Price updatePrice(@PathVariable Integer id, @PathVariable double amount) {
		
		return priceService.updateAmount(id, amount);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/deletingprice/{id}")
	public void deletePrice(@PathVariable Integer id) {
		
		priceService.delete(id);
	}
	
	
	@PreAuthorize("hasAuthority('HOST')")
	@PostMapping("/newprice")
	public Price addPrice(@RequestBody Price price) {
		
		return priceService.addPrice(price);
	}
}
