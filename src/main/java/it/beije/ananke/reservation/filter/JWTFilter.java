package it.beije.ananke.reservation.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import it.beije.ananke.reservation.security.JwtUtility;
import it.beije.ananke.reservation.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class JWTFilter extends OncePerRequestFilter {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JwtUtility jwtUtility;

	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
		String authorization = httpServletRequest.getHeader("Authorization");
		String token = null;
		String userName = null;

		if(null != authorization && authorization.startsWith("Bearer ")) {
			token = authorization.substring(7);
			userName = jwtUtility.getUsernameFromToken(token);
			log.debug("getUsername from token:	" + jwtUtility.getUsernameFromToken(token));
			log.debug("Il token è:	" + token);
			log.debug("tk date expired:  " + jwtUtility.getExpirationDateFromToken(token));
			}

		if(null != userName && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails
			= userService.loadUserByUsername(userName);

			if(jwtUtility.validateToken(token,userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
				= new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
						);

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}

		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}