package ems.erp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.erp.beans.Project;
import ems.erp.model.AdminLoginModel;
import ems.erp.model.ManagerModel;
import ems.erp.util.CBEView;


public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddProject() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(CBEView.Add_Project_JSP).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Project project = new Project();
		project.setPname(request.getParameter("pname"));
		project.setPstatus(request.getParameter("pstatus"));
		project.setDescription(request.getParameter("des"));
		project.setCost(request.getParameter("cost"));
		project.setAssignTo(request.getParameter("assignTo"));
		project.setDepartment(request.getParameter("department"));
		
		
		
        String s1 = ManagerModel.addProject(project);
        
    	if (s1.equalsIgnoreCase("sucess")) {
			request.setAttribute("msg", "Project is Added sucessfully");
			request.getRequestDispatcher(CBEView.Add_Project_JSP).forward(request, response);
		}
	}

}
