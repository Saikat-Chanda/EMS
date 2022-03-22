package ems.erp.beans;

public class Salary {
	
	private String email;
	private String month;
	private String year;
	private String amount;

	public Salary() {
		super();
	}
	public Salary(String email, String month, String year, String amount) {
		super();
		this.email = email;
		this.month = month;
		this.year = year;
		this.amount = amount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	

}
