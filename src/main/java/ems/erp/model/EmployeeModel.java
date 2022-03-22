package ems.erp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ems.erp.beans.Employee;
import ems.erp.util.MYDb;

public class EmployeeModel {
	public static String s1 = null;

	public static String addEmployee(Employee emp) {
		Connection con = MYDb.getCon();

		try {
			Statement stmt = con.createStatement();
			String sql = "insert into employee (fname,lname,dob, gender, fatherName, motherNmae, designation, department,  doj, caddress,"
					+ "paddress, email, cnumber, education, language, pskill, sskill, password) values ('"
					+ emp.getFname() + "'," + "'" + emp.getLname() + "','" + emp.getDob() + "','" + emp.getGender()
					+ "','" + emp.getFatherName() + "','" + emp.getMotherNmae() + "'," + "'" + emp.getDesignation()
					+ "','" + emp.getDepartment() + "','" + emp.getDoj() + "','" + emp.getCaddress() + "','"
					+ emp.getPaddress() + "'," + "'" + emp.getEmail() + "','" + emp.getCnumber() + "','"
					+ emp.getEducation() + "','" + emp.getLanguage() + "'," + "'" + emp.getPskill() + "','"
					+ emp.getSskill() + "','" + emp.getPassword() + "')";
			int rs = stmt.executeUpdate(sql);
			if (rs > 0) {
				s1 = "sucess";
			} else {
				s1 = "unsucess";
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return s1;
	}

	public static Employee emp;

	public static ArrayList<Employee> viewEmp() {
		Connection con = MYDb.getCon();

		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select fname, lname, email from employee");
			while (rs.next()) {
				
				emp = new Employee(rs.getString("fname"), rs.getString("lname"), rs.getString("email"));

				empList.add(emp);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return empList;
	}

	public static String deleteEmp(String email) {
		Connection con = MYDb.getCon();
		String s1 = null;
		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate("DELETE FROM employee WHERE email = '" + email + "' ");
			if (res == 1) {
				s1 = "sucess";
			} else {
				s1 = "unsucess";
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return s1;
	}

	public static Employee editEmp(String email) {
		Connection con = MYDb.getCon();
		Employee emp = new Employee();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * FROM employee WHERE email = '" + email + "' ");
			if (rs.next()) {
				emp.setFname(rs.getString("fname"));
				emp.setLname(rs.getString("lname"));
				emp.setDob(rs.getString("dob"));
				emp.setGender(rs.getString("gender"));
				emp.setFatherName(rs.getString("fatherName"));
				emp.setMotherNmae(rs.getString("motherNmae"));
				emp.setDesignation(rs.getString("designation"));
				emp.setDepartment(rs.getString("department"));
				emp.setDoj(rs.getString("doj"));
				emp.setCaddress(rs.getString("caddress"));
				emp.setPaddress(rs.getString("paddress"));
				emp.setEmail(rs.getString("email"));
				emp.setCnumber(rs.getString("cnumber"));
				emp.setEducation(rs.getString("education"));
				emp.setLanguage(rs.getString("language"));
				emp.setPskill(rs.getString("pskill"));
				emp.setSskill(rs.getString("sskill"));
				emp.setPaddress(rs.getString("password"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return emp;
	}
	
	public static String editEmployee(String editEmail, Employee emp) {
		String s1 = null;
		Connection con = MYDb.getCon();
        System.out.println(editEmail);
		try {
			Statement stmt = con.createStatement();
			String sql = "UPDATE employee SET fname = '"+emp.getFname()+"', lname= '"+emp.getLname()+"', dob = '"+emp.getDob()+"', gender="
					+ "'"+emp.getGender()+"', fatherName= '"+emp.getFatherName()+"', motherNmae = '"+emp.getMotherNmae()+"', designation="
							+ "'"+emp.getDesignation()+"', department = '"+emp.getDepartment()+"', doj='"+emp.getDob()+"', caddress="
									+ "'"+emp.getCaddress()+"', paddress = '"+emp.getPaddress()+"', email='"+emp.getEmail()+"',cnumber="
											+ "'"+emp.getCnumber()+"',education = '"+emp.getEducation()+"',language ='"+emp.getLanguage()+"', pskill="
													+ "'"+emp.getPskill()+"', sskill = '"+emp.getSskill()+"', password='"+emp.getPassword()+"' where email = '"+editEmail+"'       ";
			int rs = stmt.executeUpdate(sql);
			if (rs > 0) {
				s1 = "sucess";
			} else {
				s1 = "unsucess";
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return s1;
		
	}
}
