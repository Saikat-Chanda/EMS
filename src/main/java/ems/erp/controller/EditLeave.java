package ems.erp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.erp.model.ReportsModel;
import ems.erp.util.CBEView;


public class EditLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public EditLeave() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String email = request.getParameter("email");
		String op = request.getParameter("op");
		System.out.println(email + " " + op);

		if (op.equalsIgnoreCase("edit")) {
			request.setAttribute("editMsg", email);
			request.getRequestDispatcher(CBEView.ADD_LEAVE2).forward(request, response);

		} else if (op.equalsIgnoreCase("delete")) {

			String emailDelete = request.getParameter("delEmail");
			String s1 = ReportsModel.deleteLeave(emailDelete);
			System.out.println("s111 " + s1);
			if (s1.equalsIgnoreCase("sucess")) {
				request.setAttribute("msg", "Record is delete Sucessfully");
				request.getRequestDispatcher(CBEView.VIEW_LEAVE_Jsp).forward(request, response);

			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
