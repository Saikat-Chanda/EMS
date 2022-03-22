package ems.erp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.erp.beans.Employee;
import ems.erp.model.EmployeeModel;
import ems.erp.util.CBEView;


public class EditEmpCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditEmpCtl() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		request.setAttribute("editMsg", email);
		request.getRequestDispatcher(CBEView.ADMIN_ADD_EMP).forward(request, response);
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
