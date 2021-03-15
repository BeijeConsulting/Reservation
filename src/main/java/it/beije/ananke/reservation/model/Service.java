package it.beije.ananke.reservation.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="open_date")
	private LocalDate openDate;
	
	@Column(name="close_date")
	private LocalDate closeDate;
	
	@Column(name="open_time")
	private LocalTime openTime;
	
	@Column(name="close_time")
	private LocalTime closeTime;
	
	@Column(name="available_places")
	private Integer availablePlaces;
	
	@Column(name="total_places")
	private Integer totalPlaces;
	
	@Column(name="structure_id")
	private Integer structureId;
	
	@Column(name="open")
	private boolean open;
	
	@Column(name="service_name")
	private String serviceName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public LocalDate getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}

	public Integer getAvailablePlaces() {
		return availablePlaces;
	}

	public void setAvailablePlaces(Integer availablePlaces) {
		this.availablePlaces = availablePlaces;
	}

	public Integer getTotalPlaces() {
		return totalPlaces;
	}

	public void setTotalPlaces(Integer totalPlaces) {
		this.totalPlaces = totalPlaces;
	}

	public Integer getStructureId() {
		return structureId;
	}

	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", openDate=" + openDate + ", closeDate=" + closeDate + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + ", availablePlaces=" + availablePlaces + ", totalPlaces=" + totalPlaces
				+ ", structureId=" + structureId + ", open=" + open + ", serviceName=" + serviceName + "]";
	}
	
	
}
