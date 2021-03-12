package it.beije.ananke.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int invoiceId;
	
	public Invoice() {
		super();
	}
	public Invoice(int invoiceId, int reservationId, String paymentMethod, int total) {
		super();
		this.invoiceId = invoiceId;
		this.reservationId = reservationId;
		this.paymentMethod = paymentMethod;
		this.total = total;
	}

	@Column(name="reservation_id")
	private int reservationId;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	@Column(name="total")
	private int total;
	
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
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
		return "Invoice [invoiceId=" + invoiceId + ", reservationId=" + reservationId + ", paymentMethod="
				+ paymentMethod + ", total=" + total + "]";
	}
	
}
