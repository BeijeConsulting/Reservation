package it.beije.ananke.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

	//@Query(value = "SELECT * FROM Address a WHERE u.status = :userId", nativeQuery = true)
	@Query(value = "SELECT * from address WHERE user_id = ?1", nativeQuery = true)
	public Address findByUserId(Integer userId);

	//@Query(value = "SELECT * FROM Address a WHERE u.status = :companyId", nativeQuery = true)
	@Query(value = "SELECT * from address WHERE company_id = ?1", nativeQuery = true)
	public Address findByCompanyId(Integer companyId);

	//@Query(value = "SELECT * FROM Address a WHERE u.status = :buildingId", nativeQuery = true)
	@Query(value = "SELECT * from address WHERE structure_id = ?1", nativeQuery = true)
	public Address findByStructureId(Integer buildingId);
	
}
