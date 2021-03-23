package it.beije.ananke.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.reservation.model.Services;
import it.beije.ananke.reservation.repository.ServiceRepository;

@Service
public class ServicesService {

	@Autowired
	private ServiceRepository serviceRepository;

	public Services insertServices(Services service) {
		return serviceRepository.save(service);
	}

	public void deleteServices(Services service) {
		serviceRepository.delete(service);
	}

	public List<Services> readServicesByStructureId(Integer id) {
		return serviceRepository.findByStructureId(id);
	}

	public Services readServicesById(Integer id) {
		return serviceRepository.findByServicesId(id);
	}

	public List<Services> readServicesByName(String name) {
		return serviceRepository.findByServicesName(name);
	}
	public List<Services> readServicesAll() {
		return serviceRepository.findAll();
	}

	public Services updateServices(Services service, Integer id) {
		Services oldServices = serviceRepository.findByServicesId(id);
		if(oldServices==null) {
			return oldServices;
		}
		else {
			oldServices.setAvailablePlaces(service.getAvailablePlaces());
			oldServices.setStructureId(service.getStructureId());
			oldServices.setOpenDate(service.getOpenDate());
			oldServices.setOpenTime(service.getOpenTime());
			oldServices.setCloseDate(service.getCloseDate());
			oldServices.setCloseTime(service.getCloseTime());
			oldServices.setServiceName(service.getServiceName());
			oldServices.setTotalPlaces(service.getTotalPlaces());
			return serviceRepository.save(oldServices);
		}		
	}
}
