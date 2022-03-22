package ems.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.erp.beans.Employee;
import ems.erp.model.EmployeeModel;
import ems.erp.util.CBEView;


public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public AddEmployee() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	      request.getRequestDispatcher(CBEView.ADMIN_ADD_EMP).forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		Employee emp = new Employee();
		String email = request.getParameter("editEmail");
		
		String usession = (String) request.getSession(false).getAttribute("empUser");
		emp.setFname(request.getParameter("fname"));
		emp.setLname(request.getParameter("lname"));
		emp.setDob(request.getParameter("dob"));
		emp.setGender(request.getParameter("gender"));
		emp.setFatherName(request.getParameter("fatherName"));
		emp.setMotherNmae(request.getParameter("motherNmae"));
		emp.setDesignation(request.getParameter("designation"));
		emp.setDepartment(request.getParameter("department"));
		emp.setDoj(request.getParameter("doj"));
		emp.setCaddress(request.getParameter("caddress"));
		emp.setPaddress(request.getParameter("paddress"));
		emp.setEmail(request.getParameter("email"));
		emp.setCnumber(request.getParameter("cnumber"));
		emp.setEducation(request.getParameter("education"));
		emp.setLanguage(request.getParameter("language"));
		emp.setPskill(request.getParameter("pskill"));
		emp.setSskill(request.getParameter("sskill"));
		emp.setPassword(request.getParameter("maritalStatus"));
		if(email==null) {
		String s1 = EmployeeModel.addEmployee(emp);
		if(s1.equalsIgnoreCase("sucess")) {
			request.setAttribute("msg", "Data is inserted sucessfully");
			request.getRequestDispatcher(CBEView.ADMIN_ADD_EMP).forward(request, response);
		}else {
			request.setAttribute("errorMsg", "Something Going wrong");
			request.getRequestDispatcher(CBEView.ADMIN_ADD_EMP).forward(request, response);
		}
		}else {
			String s1 = EmployeeModel.editEmployee(email, emp);
			if(s1.equalsIgnoreCase("sucess") && usession == null) {
				request.setAttribute("updateMsg", "Data is updated sucessfully");
				request.getRequestDispatcher(CBEView.VIEW_EMP).forward(request, response);
				
			}else if(s1.equalsIgnoreCase("sucess") && usession != null) {
				request.setAttribute("updateMsg", "Data is updated sucessfully");
				request.getRequestDispatcher(CBEView.ADMIN_ADD_EMP).forward(request, response);
			}
		}
	}

}
