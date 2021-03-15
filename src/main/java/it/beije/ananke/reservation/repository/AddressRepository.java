package it.beije.ananke.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

	public Address findByUserId(Integer userId);

	public Address findByCompanyId(Integer companyId);

	public Address findByBuildingId(Integer buildingId);
	
}
