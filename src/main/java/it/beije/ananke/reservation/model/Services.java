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
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer servicesId;
	
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
	private Structure structureId;
	
	@Column(name="open")
	private boolean open;
	
	@Column(name="service_name")
	private String servicesName;
	public Integer getId() {
		return servicesId;
	}
	public void setId(Integer id) {
		this.servicesId = id;
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
	public Structure getStructureId() {
		return structureId;
	}
	public void setStructureId(Structure structure) {
		this.structureId = structure;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getServiceName() {
		return servicesName;
	}
	public void setServiceName(String servicesName) {
		this.servicesName = servicesName;
	}
	@Override
	public String toString() {
		return "Service [id=" + servicesId + ", openDate=" + openDate + ", closeDate=" + closeDate + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + ", availablePlaces=" + availablePlaces + ", totalPlaces=" + totalPlaces
				+ ", building=" + structureId + ", open=" + open + ", serviceName=" + servicesName + "]";
	}
	
	
}