package it.beije.ananke.reservation.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer companyId;
	
	@Column(name="business_name")
	private String businessName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="manager_name")
	private String managerName;
	
	@OneToMany
	@JoinColumn(name="company_id")
	private Collection<Address> addresses;

	public Integer getId() {
		return companyId;
	}

	public void setId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", businessName=" + businessName + ", description=" + description
				+ ", managerName=" + managerName + "]";
	}
	
}
