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
import javax.persistence.Table;

@Entity
@Table(name="authority")
public class Authority {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer authorityId;
	
	@Column(name="authority_name")
	private String authority;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_authority", 
	joinColumns = @JoinColumn(name = "authority_id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Collection<User> users;
	
	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authority [authorityId=" + authorityId + ", authority=" + authority + "]";
	}
	
}
