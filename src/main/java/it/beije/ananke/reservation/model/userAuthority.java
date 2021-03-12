package it.beije.ananke.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user_authority")
public class userAuthority {

	@Column(name="user_id")
	Integer userId;
	@Column(name="authority_id")
	Integer authorityId;
}
