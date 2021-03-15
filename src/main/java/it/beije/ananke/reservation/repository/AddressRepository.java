package it.beije.ananke.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

	@Query(value = "SELECT * FROM Address a WHERE u.status = :userId", nativeQuery = true)
	public Address findByUserId(Integer userId);

	@Query(value = "SELECT * FROM Address a WHERE u.status = :companyId", nativeQuery = true)
	public Address findByCompanyId(Integer companyId);

	@Query(value = "SELECT * FROM Address a WHERE u.status = :buildingId", nativeQuery = true)
	public Address findByBuildingId(Integer buildingId);
	
}
