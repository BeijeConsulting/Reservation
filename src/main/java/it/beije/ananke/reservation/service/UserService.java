package it.beije.ananke.reservation.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.beije.ananke.reservation.model.Reservation;
import it.beije.ananke.reservation.model.User;
import it.beije.ananke.reservation.model.UserPrincipal;
import it.beije.ananke.reservation.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	@Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUserEmail(username);
        if (user == null) {
             throw new UsernameNotFoundException(username);
        }
        
        return new UserPrincipal(user).getUser();
        
    }

	public void save(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userRepository.save(user);
		
	}
	
	

	public Integer findUserByUserEmail(HttpServletRequest req) {
	
			Principal principal = req.getUserPrincipal();
			String userEmail = principal.getName();
			User user = userRepository.findByUserEmail(userEmail);
			return user.getUserId();
	}
}
