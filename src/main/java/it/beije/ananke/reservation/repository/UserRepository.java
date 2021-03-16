package it.beije.ananke.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUserEmail(String username);
	
}
