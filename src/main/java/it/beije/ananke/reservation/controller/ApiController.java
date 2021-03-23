package it.beije.ananke.reservation.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import it.beije.ananke.reservation.model.AuthenticationRequest;
import it.beije.ananke.reservation.model.AuthenticationResponse;
import it.beije.ananke.reservation.model.User;
import it.beije.ananke.reservation.repository.UserRepository;
import it.beije.ananke.reservation.security.JwtUtility;
import it.beije.ananke.reservation.service.UserService;

@RestController
public class ApiController{

  @Autowired
  UserService userService;
  
  @Autowired
  JwtUtility jwtUtility;

  @Autowired
  UserRepository userRepository;
  
  @Autowired
  AuthenticationManager authenticationManager;
  
  @Value("${profile.name}")
  String profileName;

  
  	@PreAuthorize("permitAll()")
  	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String test() throws UnknownHostException {
		//log.debug("GET /test");
		InetAddress inetAddress = InetAddress.getLocalHost();

		return "It's running the "+ profileName +" profile on " + inetAddress.getHostAddress() + " " + inetAddress.getHostName() + " | " + userRepository.count();
	}
  	
  	 @GetMapping("/")
     public String home() {
         return  "Hello world" ;
     }
  	
  	@PreAuthorize("permitAll()")
  	@PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest jwtRequest) throws Exception{

         try {
             System.out.println("sono nell'autenticate");

             
             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            		 jwtRequest.getUsername(),
            		 jwtRequest.getPassword()
             ));
             
             /*
             new UsernamePasswordAuthenticationToken(
            		 jwtRequest.getUsername(),
            		 jwtRequest.getPassword()
             );
             */
             
        	 System.out.println(jwtRequest.getUsername() + "  " + jwtRequest.getPassword());

         } catch (BadCredentialsException e) {
             throw new Exception("INVALID_CREDENTIALS", e);
         }

         final UserDetails userDetails
                 = userService.loadUserByUsername(jwtRequest.getUsername());
         
         System.out.println("UserDetail : " + userDetails);
         System.out.println("UserDetail username : " + userDetails.getUsername());

         final String token =
                 jwtUtility.generateToken(userDetails);

         return  new AuthenticationResponse(token);
     }
  	
  	@PreAuthorize("permitAll()")
  	@PostMapping("/registrate")
    public boolean registrate(@RequestBody User user) throws Exception{

  		userService.save(user);  		
  		
  		return true;
  		
     }
  	
  	@PreAuthorize("permitAll()")
  	@GetMapping("/user")
  	public User getUser() {
  		
  		User user = new User();
  		
  		return user;
  		
  	}

  
  	@PreAuthorize("permitAll()")
  	@GetMapping("/signin2")
  	public AuthenticationRequest signin() {
	  
	  AuthenticationRequest request = new AuthenticationRequest();
	  
	  return request;

  	}


}