package it.beije.ananke.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	@Query(value = "SELECT * from reservation WHERE user_id = ?1", nativeQuery = true)
	List<Reservation> findAllReservationByUserId(Integer userId);
	
}
