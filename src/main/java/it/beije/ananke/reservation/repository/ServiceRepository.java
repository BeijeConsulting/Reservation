package it.beije.ananke.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Integer>{

	public List<Services> findByStructureId(Integer id);
	
	public Services findByServicesId(Integer id);
	
	public List<Services> findByServicesName(String name);

	public List<Services> findAll();
	
}
