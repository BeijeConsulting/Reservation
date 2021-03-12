package it.beije.ananke.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="structure")
public class Structure {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Integer structureId;
	@Column(name="name")
	String structureName;
	@Column(name="host_id")
	Integer hostId;
	@Column(name="address_id")
	Integer addressId;
	@Column(name="structure_email")
	String structureEmail;
	@Column(name="telephone_number")
	String structureTelephoneNumber;
	@Column(name="user_id")
	Integer userId;

	public Integer getStructureId() {
		return structureId;
	}
	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
	}
	public String getStructureName() {
		return structureName;
	}
	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}
	public Integer getHostId() {
		return hostId;
	}
	public void setHostId(Integer hostId) {
		this.hostId = hostId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getStructureEmail() {
		return structureEmail;
	}
	public void setStructureEmail(String structureEmail) {
		this.structureEmail = structureEmail;
	}
	public String getStructureTelephoneNumber() {
		return structureTelephoneNumber;
	}
	public void setStructureTelephoneNumber(String structureTelephoneNumber) {
		this.structureTelephoneNumber = structureTelephoneNumber;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
