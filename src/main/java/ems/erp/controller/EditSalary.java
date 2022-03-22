package ems.erp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.erp.model.EmployeeModel;
import ems.erp.model.ReportsModel;
import ems.erp.util.CBEView;


public class EditSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditSalary() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String op = request.getParameter("op");
		
		
		if(op.equalsIgnoreCase("edit")) {
		request.setAttribute("editMsg", email);
		request.getRequestDispatcher(CBEView.ADD_SALARY2).forward(request, response);
		
		}else if(op.equalsIgnoreCase("delete")) {
			
			String emailDelete = request.getParameter("emailDelete");
			String s1 = ReportsModel.deleteSalary(emailDelete);
		
			if(s1.equalsIgnoreCase("sucess")){
				request.setAttribute("msg", "Record is delete Sucessfully");
				request.getRequestDispatcher(CBEView.VIEW_SALARY_Jsp).forward(request, response);
				
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
