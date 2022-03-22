package ems.erp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ems.erp.beans.Admin;
import ems.erp.beans.Salary;
import ems.erp.beans.UserAdmin;
import ems.erp.util.MYDb;

public class AdminLoginModel {
	
	
	public static ArrayList<String> DeptEmpList(String dname) {
		Connection con = MYDb.getCon();

		ArrayList<String> dList = new ArrayList<String>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee where department='"+dname+"'");
			while (rs.next()) {

			

				dList.add(rs.getString("fname"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dList;
	}
	
	
	public static ArrayList<String> DeptList() {
		Connection con = MYDb.getCon();

		ArrayList<String> dList = new ArrayList<String>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from department");
			while (rs.next()) {

			

				dList.add(rs.getString("dname"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dList;
	}
	
	
	public static String AddDepartment(String dname) {
		String s1 = null;
		Connection con = MYDb.getCon();

		try {
			Statement stmt = con.createStatement();
			String sql = "insert into department(dname)values('"+dname+"')";
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
	
	
	public static String AddAdmin(Admin admin) {
		String s1 = null;
		Connection con = MYDb.getCon();

		try {
			Statement stmt = con.createStatement();
			String sql = "insert into admin(username,password)values('"+admin.getUname()+"','"+admin.getPass()+"')";
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
	
    
	public static String verifyLogin(UserAdmin user) {
		String result= null; 
		Connection con = MYDb.getCon();
		System.out.println("Admin" +user.getUname()+ "  "+user.getPassword());

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from admin where username='"+user.getUname()+"' and password = '"+user.getPassword()+"' ");
			if(rs.next()) {
				result = "sucess";
			}else {
				result = "unsucess";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	public static String verifyEmpLogin(UserAdmin user) {
		String s1=null;
		Connection con = MYDb.getCon();
        System.out.println(user.getUname()+"  "+user.getPassword());
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee where email='"+user.getUname()+"' and password = '"+user.getPassword()+"' ");
			if(rs.next()) {
				s1 = "sucess";
			}else {
				s1="un";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return s1;
	}
	
	
	public static String verifyManagerLogin(UserAdmin user) {
		String s1=null;
		Connection con = MYDb.getCon();
        System.out.println(user.getUname()+"  "+user.getPassword()+"  "+user.getDesignation());
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee where email='"+user.getUname()+"' and password = '"+user.getPassword()+"' and designation = '"+user.getDesignation()+"'");
			if(rs.next()) {
				s1 = "sucess";
			}else {
				s1="un";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return s1;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
