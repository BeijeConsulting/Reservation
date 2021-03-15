package it.beije.ananke.reservation.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.reservation.model.Building;
import it.beije.ananke.reservation.repository.BuildingRepository;

@Service
public class BuildingService {
@Autowired
private BuildingRepository buildingRepository;

public Building addBuilding() {
	buildingRepository.save(null);
	return null;
}

}
