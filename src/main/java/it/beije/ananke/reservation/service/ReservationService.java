package it.beije.ananke.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.reservation.model.Reservation;
import it.beije.ananke.reservation.model.User;
import it.beije.ananke.reservation.repository.ReservationRepository;
import it.beije.ananke.reservation.repository.UserRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Reservation> findAll(String userEmail) {
		
		User user = userRepository.findByUserEmail(userEmail);
		
		List<Reservation> prenotazioni = reservationRepository.findAllReservationByUserId(user.getUserId());
		
		return prenotazioni;
	}

	
	public List<Reservation> findByUserId(Integer id) {
		
		return reservationRepository.findAllReservationByUserId(id);
	}

}
