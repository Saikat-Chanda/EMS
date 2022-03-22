package ems.erp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.erp.model.EmployeeModel;
import ems.erp.util.CBEView;


public class DeleteEmpCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteEmpCtl() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email = request.getParameter("email");
		String s1 = EmployeeModel.deleteEmp(email);
		if(s1.equalsIgnoreCase("sucess")){
			request.setAttribute("msg", "Record is delete Sucessfully");
			request.getRequestDispatcher(CBEView.VIEW_EMP).forward(request, response);
			
		}else{
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
