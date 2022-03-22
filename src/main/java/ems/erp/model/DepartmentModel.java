package ems.erp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ems.erp.beans.Department;
import ems.erp.beans.Employee;
import ems.erp.util.MYDb;

public class DepartmentModel {
	
	public static ArrayList<Department> DepartmentList() {
		Connection con = MYDb.getCon();
       
		ArrayList<Department> deptList = new ArrayList<Department>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from department");
			while (rs.next()) {
				 Department dept = new Department();
				dept.setName(rs.getString("dname"));
				deptList.add(dept);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return deptList;
	}

}
