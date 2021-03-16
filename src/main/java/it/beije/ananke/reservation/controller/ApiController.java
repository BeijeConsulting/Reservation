package it.beije.ananke.reservation.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.reservation.model.AuthenticationRequest;
import it.beije.ananke.reservation.model.User;
import it.beije.ananke.reservation.repository.UserRepository;
import it.beije.ananke.reservation.security.JwtTokenProvider;

@RestController
public class ApiController extends FirstController{

  @Autowired
  JwtTokenProvider jwtTokenProvider;

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

  
  @PreAuthorize("permitAll()")
  @PostMapping("/signin")
  public ResponseEntity<Map<Object, Object>> signin(@RequestBody AuthenticationRequest data) {

      try {
          String username = data.getUsername();
          authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
          User user = userRepository.findByUserEmail(username);
          
          if (user == null) {
        	  throw new UsernameNotFoundException("Username " + username + " not found");
          }
        		  // .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
          
          List<String> roles = null;
          roles.add(user.getAuthorities().get(0).getAuthority());
          
          String token = jwtTokenProvider.createToken(username, roles);
         
          // RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);
        
          Map<Object, Object> model = new HashMap<>();
          model.put("username", username);
          model.put("token", token);
          // model.put("refreshToken", refreshToken.getToken());
          
          return ok(model);
          
      } catch (AuthenticationException e) {
          throw new BadCredentialsException("Invalid username/password supplied");
      } catch (Exception e) {
          throw e;
      }
  }
  
  @PreAuthorize("permitAll()")
  @GetMapping("/signin2")
  public AuthenticationRequest signin() {
	  
	  AuthenticationRequest request = new AuthenticationRequest();
	  
	  return request;

  }


}