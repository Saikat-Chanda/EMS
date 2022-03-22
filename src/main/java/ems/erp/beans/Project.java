package ems.erp.beans;

public class Project {
	
	private String Pname;
	private String pstatus;
	private String description;
	private String cost;
	private String assignTo;
	private String department;
	
	
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
	public Project(String pname, String pstatus, String description, String cost, String assignTo, String department) {
		super();
		Pname = pname;
		this.pstatus = pstatus;
		this.description = description;
		this.cost = cost;
		this.assignTo = assignTo;
		this.department = department;
	}
	public Project(String pname, String pstatus, String description, String cost) {
		super();
		Pname = pname;
		this.pstatus = pstatus;
		this.description = description;
		this.cost = cost;
	}
	public Project() {
		super();
	}
	
	

}
