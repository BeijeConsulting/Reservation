package it.beije.ananke.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="price_type")
	private String priceType;
	
	@Column(name="service_id")
	private int serviceId;
	
	@Column(name="price_type_id")
	private int priceTypeId;

	public Price() {
		super();
	}
	
	public Price(Integer priceId, double amount, String priceType, int serviceId, int priceTypeId) {
		super();
		this.priceId = priceId;
		this.amount = amount;
		this.priceType = priceType;
		this.serviceId = serviceId;
		this.priceTypeId = priceTypeId;
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

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getPriceTypeId() {
		return priceTypeId;
	}

	public void setPriceTypeId(int priceTypeId) {
		this.priceTypeId = priceTypeId;
	}
	
	@Override
	public String toString() {
		return "Price [priceId=" + priceId + ", amount=" + amount + ", priceType=" + priceType + ", serviceId="
				+ serviceId + ", priceTypeId=" + priceTypeId + "]";
	}


}
