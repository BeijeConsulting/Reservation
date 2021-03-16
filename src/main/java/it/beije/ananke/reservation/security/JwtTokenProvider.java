package it.beije.ananke.reservation.security;

import io.jsonwebtoken.*;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import it.beije.ananke.reservation.exception.InvalidJwtAuthenticationException;

@Component
public class JwtTokenProvider {    
	
	@Value("${authToken.secretKey}")
    private String secretKey;    
	
	@Value("${security.jwt.token.expire-length:3600000}")
	private long validityInMilliseconds = 3600000; // 1h   

    private UserDetailsService userDetailsService;    
	
	@PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }    
	
	public String createToken(String username, List<String> roles) {
		Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);        
        
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);        
        
        return Jwts.builder()//
            .setClaims(claims)//
            .setIssuedAt(now)//
            .setExpiration(validity)//
            .signWith(SignatureAlgorithm.HS256, secretKey)//
            .compact();
    }

	
	public Authentication getAuthentication(String token) {
        User userDetails = (User) this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }    
	
	public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }    
	
	public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }    
	
	public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token); 
            if (claims.getBody().getExpiration().before(new Date())) {
                return false;
            } 
            return true;
        } 
        
        /*
        catch (ExpiredJwtException e) {
            throw new InvalidJwtAuthenticationException("Expired JWT token", InvalidJwtAuthenticationException.EXPIRED);
        }
        */   
        catch (JwtException | IllegalArgumentException e) {
            throw new InvalidJwtAuthenticationException("Invalid JWT token", InvalidJwtAuthenticationException.FORBIDDEN);
        }
    }
}
