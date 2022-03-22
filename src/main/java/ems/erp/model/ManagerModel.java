package ems.erp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ems.erp.beans.Employee;
import ems.erp.beans.Project;
import ems.erp.beans.Salary;
import ems.erp.util.MYDb;

public class ManagerModel {
	
	public static String addProject(Project project) {
		String s1 = null;
		Connection con = MYDb.getCon();

		try {
			Statement stmt = con.createStatement();
			String sql = "insert into project(name,status,des,cost,assignTo,department)values('" + project.getPname() + "', '"
					+ project.getPstatus() + "'," + "'" + project.getDescription() + "','" + project.getCost() + "', '"+project.getAssignTo()+"','"+project.getDepartment()+"')";
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
	
	static Project pro= null;
	public static ArrayList<Project> viewProject() {
		Connection con = MYDb.getCon();

		ArrayList<Project> proList = new ArrayList<Project>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from project");
			while (rs.next()) {
				
				pro = new Project(rs.getString("name"), rs.getString("status"), rs.getString("des"), rs.getString("cost"), rs.getString("assignTo"), rs.getString("department"));

				proList.add(pro);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return proList;
	}

}
