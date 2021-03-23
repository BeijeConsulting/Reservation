package it.beije.ananke.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.Structure;

@Repository
public interface StructureRepository extends JpaRepository<Structure, Integer>{

	
}
