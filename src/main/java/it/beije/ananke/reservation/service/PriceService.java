package it.beije.ananke.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.reservation.model.Price;
import it.beije.ananke.reservation.model.PriceType;
import it.beije.ananke.reservation.repository.PriceRepository;
import it.beije.ananke.reservation.repository.PriceTypeRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private PriceTypeRepository priceTypeRepository;
	
	
	public String findPriceTypeNameById(Integer id) {
		
		 PriceType priceType = priceTypeRepository.findById(id).get();
		 
		return priceType.getPriceTypeName();
	}
	
	
	public List<Price> findAll(){
		
		return priceRepository.findAll();
	}
	
	
	public List<Price> findAllByServicesId(Integer id){
		
		return priceRepository.findAllByServicesId(id);
	}
	
	
	public Price updateAmount(Integer id, double amount) {
		
		if(priceRepository.existsById(id)) {
			
			Price price = priceRepository.findById(id).get();
			
			price.setAmount(amount);
			
			return priceRepository.save(price);
		}
		
		else return null;	
	}
	
	
	public void delete(Integer id) {
		
		priceRepository.deleteById(id);
	}
	
	
	public Price addPrice(Price price) {
		
		if(price!=null)
		{
			return priceRepository.save(price);
		}
		else {
			return null;
		}
	}
	
}
