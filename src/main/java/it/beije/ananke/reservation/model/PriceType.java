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
@Table(name = "price_type")
public class PriceType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer priceTypeId;
	
	@Column(name="type_name")
	private String priceTypeName;
	
	@OneToMany
	@JoinColumn(name="price_type_id")
	private Collection<Price> prices;

	public PriceType() {
		super();
	
	}

	public PriceType(Integer id, String priceTypeName) {
		super();
		this.priceTypeId = id;
		this.priceTypeName = priceTypeName;
	}

	public Integer getId() {
		return priceTypeId;
	}

	public void setId(Integer id) {
		this.priceTypeId = id;
	}

	

	public String getPriceTypeName() {
		return priceTypeName;
	}

	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}
	
	@Override
	public String toString() {
		return "PriceType [priceTypeId=" + priceTypeId + ", priceTypeName=" + priceTypeName + "]";
	}

}
