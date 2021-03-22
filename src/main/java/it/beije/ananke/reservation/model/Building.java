package it.beije.ananke.reservation.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="structure")
public class Building {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer buildingId;
	
	@Column(name="name")
	private String buildingName;
	
	@Column(name="structure_email")
	private String buildingEmail;
	
	@Column(name="telephone_number")
	private String structureTelephoneNumber;
	
	/*
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	*/
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	@OneToMany
	@JoinColumn(name="structure_id")
	private Collection<Address> addresses;

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingEmail() {
		return buildingEmail;
	}

	public void setBuildingEmail(String buildingEmail) {
		this.buildingEmail = buildingEmail;
	}

	public String getStructureTelephoneNumber() {
		return structureTelephoneNumber;
	}

	public void setStructureTelephoneNumber(String structureTelephoneNumber) {
		this.structureTelephoneNumber = structureTelephoneNumber;
	}

	/*
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	*/

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

}
