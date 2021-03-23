package it.beije.ananke.reservation.model;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="service")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer serviceId;
	
	@Column(name="open_date")
	private Date openDate;
	
	@Column(name="close_date")
	private Date closeDate;
	
	@Column(name="open_time")
	private Time openTime;
	
	@Column(name="close_time")
	private Time closeTime;
	
	@Column(name="available_places")
	private Integer availablePlaces;
	
	@Column(name="total_places")
	private Integer totalPlaces;
	
	@ManyToOne
	@JoinColumn(name="structure_id")
	private Structure building;
	
	@Column(name="open")
	private boolean open;
	
	@Column(name="service_name")
	private String serviceName;

	public Integer getId() {
		return serviceId;
	}

	public void setId(Integer id) {
		this.serviceId = id;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Time getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}

	public Time getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Time closeTime) {
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

	public Structure getBuildingId() {
		return building;
	}

	public void setStructureId(Structure building) {
		this.building = building;
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
		return "Service [id=" + serviceId + ", openDate=" + openDate + ", closeDate=" + closeDate + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + ", availablePlaces=" + availablePlaces + ", totalPlaces=" + totalPlaces
				+ ", building=" + building + ", open=" + open + ", serviceName=" + serviceName + "]";
	}
	
	
}
