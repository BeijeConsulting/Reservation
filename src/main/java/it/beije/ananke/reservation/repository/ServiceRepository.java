package it.beije.ananke.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer>{

	
}
