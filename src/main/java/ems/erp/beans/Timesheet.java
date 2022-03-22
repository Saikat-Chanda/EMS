package ems.erp.beans;

public class Timesheet {
	
	private String email;
	private String description;
	private String workTittle;
	private String hours;
	private String date;
	
	
	
	
	public Timesheet() {
		super();
	}
	public Timesheet(String email, String description, String workTittle, String hours, String date) {
		super();
		this.email = email;
		this.description = description;
		this.workTittle = workTittle;
		this.hours = hours;
		this.date = date;
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
	public String getWorkTittle() {
		return workTittle;
	}
	public void setWorkTittle(String workTittle) {
		this.workTittle = workTittle;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
