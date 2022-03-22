package ems.erp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import com.mchange.util.impl.EmptyMEnumeration;

import ems.erp.beans.Employee;
import ems.erp.beans.Leave;
import ems.erp.beans.Salary;
import ems.erp.beans.Timesheet;
import ems.erp.util.MYDb;

public class ReportsModel {

	public static String addSalary(Salary salary) {
		String s1 = null;
		Connection con = MYDb.getCon();

		try {
			Statement stmt = con.createStatement();
			String sql = "insert into addsalary(email,month,year,amount)values('" + salary.getEmail() + "', '"
					+ salary.getMonth() + "'," + "'" + salary.getYear() + "','" + salary.getAmount() + "')";
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

	public static Salary sal;

	public static ArrayList<Salary> viewSalary() {
		Connection con = MYDb.getCon();

		ArrayList<Salary> salaryList = new ArrayList<Salary>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from addsalary");
			while (rs.next()) {

				sal = new Salary(rs.getString("email"), rs.getString("month"), rs.getString("year"),
						rs.getString("amount"));

				salaryList.add(sal);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return salaryList;
	}

	public static Salary editSalaryGet(String email) {
		Connection con = MYDb.getCon();
		Salary sal = new Salary();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * FROM addsalary WHERE email = '" + email + "' ");
			if (rs.next()) {
				sal.setEmail(rs.getString("email"));
				sal.setMonth(rs.getString("month"));
				sal.setYear(rs.getString("year"));
				sal.setAmount(rs.getString("amount"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return sal;
	}

	public static String deleteSalary(String email) {
		Connection con = MYDb.getCon();
		String s1 = null;
		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate("DELETE FROM addsalary WHERE email = '" + email + "' ");
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

	public static String updateSalary(String email, Salary sal) {
		String s1 = null;
		Connection con = MYDb.getCon();

		try {
			Statement stmt = con.createStatement();
			String sql = "UPDATE addsalary SET email = '" + sal.getEmail() + "', month= '" + sal.getMonth()
					+ "', year = '" + sal.getYear() + "', amount=" + "'" + sal.getAmount() + "' where email = '" + email
					+ "'";
			int rs = stmt.executeUpdate(sql);
			if (rs == 1) {
				s1 = "sucess";
			} else {
				s1 = "unsucess";
			}

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return s1;
	}

	public static String addTimeSheet(Timesheet timesheet) {
		String s1 = null;
		Connection con = MYDb.getCon();

		try {
			Statement stmt = con.createStatement();
			String sql = "insert into timesheet (email, tittle,des,hours,date) values('" + timesheet.getEmail() + "','"
					+ timesheet.getWorkTittle() + "'," + "'" + timesheet.getDescription() + "','" + timesheet.getHours()
					+ "','" + timesheet.getDate() + "')";
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

	public static Timesheet editTimesheet(String email) {
		Connection con = MYDb.getCon();
		Timesheet ts = new Timesheet();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * FROM timesheet WHERE email = '" + email + "' ");
			if (rs.next()) {
				ts.setEmail(rs.getString("email"));
				ts.setWorkTittle(rs.getString("tittle"));
				ts.setDescription(rs.getString("des"));
				ts.setHours(rs.getString("hours"));
				ts.setDate(rs.getString("date"));
			}

		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return ts;
	}

	public static String updateTimesheet(String email, Timesheet ts) {
		String s1 = null;
		Connection con = MYDb.getCon();

		try {
			Statement stmt = con.createStatement();
			String sql = "UPDATE timesheet SET email = '" + ts.getEmail() + "', tittle= '" + ts.getWorkTittle()
					+ "', des = '" + ts.getDescription() + "', hours=" + "'" + ts.getHours() + "',  date ='"
					+ ts.getDate() + "' where email = '" + email + "' ";
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

	public static ArrayList<Timesheet> viewTimesheet() {
		Timesheet tSheet;
		Connection con = MYDb.getCon();

		ArrayList<Timesheet> tSheetList = new ArrayList<Timesheet>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from timesheet");
			while (rs.next()) {

				tSheet = new Timesheet(rs.getString("email"), rs.getString("tittle"), rs.getString("des"),
						rs.getString("hours"), rs.getString("date"));

				tSheetList.add(tSheet);
			}

		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return tSheetList;
	}

	public static ArrayList<Timesheet> viewTimesheet(String email) {
		Timesheet tSheet;
		Connection con = MYDb.getCon();

		ArrayList<Timesheet> tSheetList = new ArrayList<Timesheet>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from timesheet where email = '" + email + "'");
			while (rs.next()) {

				tSheet = new Timesheet(rs.getString("email"), rs.getString("tittle"), rs.getString("des"),
						rs.getString("hours"), rs.getString("date"));

				tSheetList.add(tSheet);
			}

		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return tSheetList;
	}

	public static String deleteTimesheet(String email) {
		Connection con = MYDb.getCon();
		String s1 = null;
		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate("DELETE FROM timesheet WHERE email = '" + email + "' ");
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

	public static String addLeave(Leave leave) {
		String s1 = null;
		Connection con = MYDb.getCon();
		
		try {
			Statement stmt = con.createStatement();

			int rs = stmt.executeUpdate("insert into eleave (email,des,fdate,tdate,status) values('" + leave.getEmail()
					+ "','" + leave.getDescription() + "'," + "'" + leave.getFromDate() + "','" + leave.getToDate()
					+ "','" + leave.getStatus() + "')");
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

	
	public static ArrayList<Leave> viewLeave() {
		Leave leave;
		Connection con = MYDb.getCon();

		ArrayList<Leave> leaveList = new ArrayList<Leave>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from eleave");
			while (rs.next()) {

				leave = new Leave(rs.getInt("lid"), rs.getString("email"), rs.getString("des"), rs.getString("fdate"),
						rs.getString("tdate"), rs.getString("status"));

				leaveList.add(leave);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return leaveList;
	}

	public static ArrayList<Leave> viewLeave(String email) {
		Leave leave;
		Connection con = MYDb.getCon();

		ArrayList<Leave> leaveList = new ArrayList<Leave>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from eleave where email = '" + email + "'");
			while (rs.next()) {

				leave = new Leave(rs.getString("email"), rs.getString("des"), rs.getString("fdate"),
						rs.getString("tdate"), rs.getString("status"));

				leaveList.add(leave);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return leaveList;
	}

	public static Leave editLeave(String lid) {
		Connection con = MYDb.getCon();
		Leave leave = new Leave();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * FROM eleave WHERE lid = '" + lid + "' ");
			if (rs.next()) {
				leave.setEmail(rs.getString("email"));
				leave.setDescription(rs.getString("des"));
				leave.setFromDate(rs.getString("fdate"));

				leave.setToDate(rs.getString("tdate"));
				leave.setStatus(rs.getString("status"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return leave;
	}

	public static String updateLeave(String lid, Leave leave) {
		String s1 = null;
		Connection con = MYDb.getCon();

		try {
			Statement stmt = con.createStatement();
			String sql = "UPDATE eleave SET email = '" + leave.getEmail() + "',  des = '" + leave.getDescription()
					+ "', fdate= '" + leave.getFromDate() + "', tdate=" + "'" + leave.getToDate() + "',  status ='"
					+ leave.getStatus() + "' where lid = '" + lid + "' ";
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

	public static String deleteLeave(String email) {
		Connection con = MYDb.getCon();
		String s1 = null;
		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate("DELETE FROM eleave WHERE email = '" + email + "' ");
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

}
