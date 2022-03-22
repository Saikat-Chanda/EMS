package ems.erp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.erp.beans.Admin;
import ems.erp.model.AdminLoginModel;
import ems.erp.util.CBEView;


public class AddAdminCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddAdminCtl() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		request.getRequestDispatcher(CBEView.Create_Admin_JSP).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Admin admin = new Admin();
		admin.setUname(request.getParameter("uname"));
		admin.setPass(request.getParameter("pass"));
        String s1 = AdminLoginModel.AddAdmin(admin);
        
    	if (s1.equalsIgnoreCase("sucess")) {
			request.setAttribute("msg", "New Admin is Added sucessfully");
			request.getRequestDispatcher(CBEView.Create_Admin_JSP).forward(request, response);
		}
		
	}

}
