package ems.erp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.erp.beans.Timesheet;
import ems.erp.model.ReportsModel;
import ems.erp.util.CBEView;


public class AddTimesheetCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddTimesheetCtl() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		request.getRequestDispatcher(CBEView.ADD_TimeSheet_jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Timesheet timesheet = new Timesheet();
		String email = request.getParameter("editMsgTime");
		timesheet.setEmail(request.getParameter("email"));
		timesheet.setWorkTittle(request.getParameter("tittle"));
		timesheet.setDescription(request.getParameter("des"));
		timesheet.setHours(request.getParameter("whours"));
		 timesheet.setDate(request.getParameter("date"));
       
   if(email==null) {
	   String s1 =  ReportsModel.addTimeSheet(timesheet);
   	if(s1.equalsIgnoreCase("sucess")) {
		request.setAttribute("msg", "Timesheeet is Added sucessfully");
		request.getRequestDispatcher(CBEView.ADD_TimeSheet_jsp).forward(request, response);
	}
   	
   }else {
		String s2 =  ReportsModel.updateTimesheet(email, timesheet);
		if(s2.equalsIgnoreCase("sucess")) {
			request.setAttribute("msg", "Timesheeet is Updated sucessfully");
			request.getRequestDispatcher(CBEView.VIEW_TIMESHEET_Jsp).forward(request, response);
		}
	   
   }
		
	}

}
