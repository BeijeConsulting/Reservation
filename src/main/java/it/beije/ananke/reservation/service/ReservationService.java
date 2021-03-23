package it.beije.ananke.reservation.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.reservation.model.Reservation;
import it.beije.ananke.reservation.model.Services;
import it.beije.ananke.reservation.model.User;
import it.beije.ananke.reservation.repository.ReservationRepository;
import it.beije.ananke.reservation.repository.ServiceRepository;
import it.beije.ananke.reservation.repository.UserRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	
	public Reservation findByReservationId(Integer reservationId) {
		
		return reservationRepository.findById(reservationId)
		        .orElseThrow(() -> new EntityNotFoundException());
		
	}
	
	
	public List<Reservation> findByUserId(Integer id) {
		
		return reservationRepository.findAllReservationByUserId(id);
	}
	

	public List<Reservation> findAll() {
		
		return reservationRepository.findAll();
	}
	
	
	public Reservation newReservation(Reservation reservation, HttpServletRequest req, Integer serviceId) {
		
		User user = userRepository.findByUserEmail(req.getUserPrincipal().getName());
		Services service = serviceRepository.findByServicesId(serviceId);
		
		reservation.setUser(user);
		reservation.setService(service);
		
		return reservationRepository.save(reservation);
		
	}

	
	public void deleteReservation(Integer reservationId) {
		
		reservationRepository.deleteById(reservationId);
		
	}


	public Reservation updateReservation(Reservation reservation, Integer reservationId) {
	
		Reservation tempReservation = reservationRepository.findById(reservationId)
					.orElseThrow(() -> new EntityNotFoundException());
		
		tempReservation.setStart(reservation.getStart());
		tempReservation.setEnd(reservation.getEnd());
		tempReservation.setPersonNumber(reservation.getPersonNumber());
		
		return reservationRepository.save(tempReservation);
		
	}
	
}
