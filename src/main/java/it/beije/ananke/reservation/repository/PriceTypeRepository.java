package it.beije.ananke.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.PriceType;

@Repository
public interface PriceTypeRepository extends JpaRepository<PriceType, Integer>{

	PriceType findByPriceTypeId(Integer priceTypeId);

}
