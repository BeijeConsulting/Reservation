package it.beije.ananke.reservation.model;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User implements Principal, UserDetails, Serializable{
	
	private static final long serialVersionUID = 4865903039190150223L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer userId;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="codice_fiscale")
	private String codiceFiscale;
	
	@Column(name="password")
	private String password;

	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	@Column(name="vat_number")
	private Integer vatNumber;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_authority", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private List<Authority> authorities;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private List<Address> addresses;
	
	@OneToMany
	@JoinColumn(name="building_id")
	private List<Building> buildings;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private List<Reservation> reservations;
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		 this.userEmail = userEmail;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Company getCompanyId() {
		return company;
	}
	
	public void setCompanyId(Company company) {
		this.company = company;
	}
	
	public Integer getVatNumber() {
		return vatNumber;
	}
	
	public void setVatNumber(Integer vatNumber) {
		this.vatNumber = vatNumber;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	/*
	public List<Authority> getAuthorities() {
		return authorities;
	}
	*/
	
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<Building> getBuildings() {
		return buildings;
	}
	
	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@JsonIgnore
	public List<String> getAuthority() {
		return createStringAuth();
	}


	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return createStringAuth().stream().map(SimpleGrantedAuthority::new).collect(toList());
	}

	private List<String> createStringAuth() {
		List<String> list = new ArrayList<>();
		for(Authority r : authorities) list.add(r.getAuthority());
		return list;		 
	}

	@Override
	public String getName() {
		
		return userEmail;
	}

	@Override
	public String getUsername() {
		
		return userEmail;
	}

}
