package ems.erp.beans;

public class Leave {

	private String email;
	private String description;
	private String fromDate;
	private String toDate;
	private String status;
	private int lid;

	public Leave(int lid, String email, String description, String fromDate, String toDate, String status) {
		super();
		this.email = email;
		this.description = description;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.lid = lid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Leave() {
		super();
	}
	public Leave(String email, String description, String fromDate, String toDate, String status) {
		super();
		this.email = email;
		this.description = description;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
