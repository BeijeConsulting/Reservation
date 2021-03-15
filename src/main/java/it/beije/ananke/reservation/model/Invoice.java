package it.beije.ananke.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer invoiceId;

	@OneToOne
	@JoinColumn(name="reservation_id")
	private Reservation reservation;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	@Column(name="total")
	private int total;
	
	
	public Invoice() {
		super();
	}
	public Invoice(Integer invoiceId, String paymentMethod, int total) {
		super();
		this.invoiceId = invoiceId;
		this.paymentMethod = paymentMethod;
		this.total = total;
	}

	
	public Integer getInvoiceId() {
		return invoiceId;
	}
	
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", reservation=" + reservation + ", paymentMethod="
				+ paymentMethod + ", total=" + total + "]";
	}
	
}
