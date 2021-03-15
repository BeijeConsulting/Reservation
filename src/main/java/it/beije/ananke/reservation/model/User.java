package it.beije.ananke.reservation.model;

import java.util.Collection;

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

@Entity
@Table(name="user")
public class User {
	
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
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_authority", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private Collection<Authority> authorities;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private Collection<Address> addresses;
	
	@OneToMany
	@JoinColumn(name="building_id")
	private Collection<Building> buildings;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private Collection<Reservation> reservations;
	
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
}
