package it.beije.ananke.reservation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import it.beije.ananke.reservation.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	 private JwtTokenFilter jwtTokenFilter;
	
	@Autowired
	private UserService userService;
	
	 @Override
	 protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		 
		 	auth.userDetailsService(userService);
		 
//		    auth.inMemoryAuthentication()
//		        .withUser("host").password(passwordEncoder().encode("hostPass")).roles("HOST")
//		        .and()
//		        .withUser("customer").password(passwordEncoder().encode("customerPass")).roles("CUSTOMER")
//		        .and()
//		        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
		}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/test", "/register", "/signin2", "/signin" , "/authenticate").permitAll()
				.anyRequest().authenticated();
				
				//.and()s
			/*
			.formLogin()
				.loginPage("/login")
			    .loginProcessingUrl("/perform_login") //url a cui mandare usere e passw
				.permitAll()
				.and()
			.logout()
				.permitAll()
			.and()
			*/
			//.apply(new JwtConfigurer(jwtTokenProvider));
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	@Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
	
}