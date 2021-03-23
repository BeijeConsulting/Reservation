package it.beije.ananke.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="price")
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer priceId;
	
	@Column(name="amount")
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="service_id")
	private Services service;

	@ManyToOne
	@JoinColumn(name="price_type_id")
	private PriceType priceType;

	public Price() {
		super();
	}
	
	public Price(Integer priceId, double amount, int priceTypeId) {
		super();
		this.priceId = priceId;
		this.amount = amount;
	}

	public Integer getPriceId() {
		return priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setPriceType(PriceType priceType) {
		this.priceType = priceType;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services serviceId) {
		this.service = serviceId;
	}

	public PriceType getPriceType() {
		return priceType;
	}

}
