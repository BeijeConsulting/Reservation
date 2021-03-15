package it.beije.ananke.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_authority")
public class UserAuthority {
	
	@Id
	@Column(name = "user_id")
	private Integer userId;
	
	@Id
	@Column(name = "authority_id")
	private Integer authorityId;

	public Integer getUserId() {
		return userId;
	}

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}