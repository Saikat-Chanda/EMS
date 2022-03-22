package ems.erp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.erp.beans.Leave;
import ems.erp.beans.Salary;
import ems.erp.model.ReportsModel;
import ems.erp.util.CBEView;


public class AddLeaveCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public AddLeaveCtl() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.getRequestDispatcher(CBEView.ADD_LEAVE_jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String usession = (String) request.getSession(false).getAttribute("empUser");
		Leave leave = new Leave();
		String email = request.getParameter("editMsgLeave");
		leave.setEmail(request.getParameter("email"));
		leave.setDescription(request.getParameter("des"));
		leave.setFromDate(request.getParameter("fdate"));
		leave.setToDate(request.getParameter("tdate"));
		leave.setStatus(request.getParameter("lstatus"));

		if (email == null) {
			String s1 = ReportsModel.addLeave(leave);

			if (s1.equalsIgnoreCase("sucess")) {
				request.setAttribute("msg", "Leave is Added sucessfully");
				request.getRequestDispatcher(CBEView.ADD_LEAVE_jsp).forward(request, response);
			}
		} else {
			String s2 = ReportsModel.updateLeave(email, leave);
			if (s2.equalsIgnoreCase("sucess")) {
				request.setAttribute("msg", "Leave is Updated sucessfully");
				request.getRequestDispatcher(CBEView.VIEW_LEAVE_Jsp).forward(request, response);
			}
		}
	}

}
