package ems.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.erp.beans.Salary;
import ems.erp.model.EmployeeModel;
import ems.erp.model.ReportsModel;
import ems.erp.util.CBEView;


public class AddSalaryCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public AddSalaryCtl() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher(CBEView.ADD_SALARY_jsp).forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String email = request.getParameter("editMsggggg");
         
		Salary salary = new Salary();
		salary.setEmail(request.getParameter("email"));
		salary.setMonth(request.getParameter("month"));
		salary.setYear(request.getParameter("year"));
		salary.setAmount(request.getParameter("amount"));
         System.out.println("Add salary control "+email);
		if (email == null) {

			String s1 = ReportsModel.addSalary(salary);

			if (s1.equalsIgnoreCase("sucess")) {
				request.setAttribute("msg", "Salary is Added sucessfully");
				request.getRequestDispatcher(CBEView.ADD_SALARY_jsp).forward(request, response);
			}else {
				
				
			}

		} else {

			String s1 = ReportsModel.updateSalary(email, salary);
			System.out.println("Update response"+s1);
			if (s1.equalsIgnoreCase("sucess")) {
				request.setAttribute("updateMsg", "Data is updated sucessfully");
				request.getRequestDispatcher(CBEView.VIEW_SALARY_Jsp).forward(request, response);

			}else {
				
			}
		}
	}

}
