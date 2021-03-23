package it.beije.ananke.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer>{

	@Query(nativeQuery= true, value="SELECT * FROM price WHERE service_id = ?1")
	List<Price> findAllByServicesId(Integer id);
	
}
