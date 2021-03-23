package it.beije.ananke.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.reservation.model.Address;
import it.beije.ananke.reservation.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	public Address insertAddress(Address address) {	
		return addressRepository.save(address);
	}
	
	public Address updateAddress(Address address,Integer id) {
		return addressRepository.saveAndFlush(address);
	}
	
	public void deleteAddress(Integer addressId) {
		addressRepository.deleteById(addressId);
		
	}
	
	public Address findByUserId(Integer userId) {
		return addressRepository.findByUserId(userId);
	}
	
	public Address findByCompanyId(Integer companyId) {
		return addressRepository.findByCompanyId(companyId);
	}
	
	public Address findByStructureId(Integer structureId) {
		return addressRepository.findByStructureId(structureId);
		
	}
	
}
