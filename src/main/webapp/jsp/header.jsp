<%@page import="ems.erp.util.CBEView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<title>Employee Management System</title>
</head>
<body>
	<%
		String adminUser = (String) session.getAttribute("adminUser");
		String empUser = (String) session.getAttribute("empUser");
		String managerUser = (String) session.getAttribute("managerUser");

		if (adminUser != null && empUser == null && managerUser == null) {
	%>
	<ul>
		<li><a href="<%=CBEView.ADD_EMP%>">Add Employee</a></li>
		<li><a href="<%=CBEView.ADD_SALARY%>">Add Salary</a></li>
		<li><a href="<%=CBEView.ADD_TimeSheet%>">Add TimeSheet</a></li>
		<li><a href="<%=CBEView.ADD_LEAVE%>">Add Leave</a></li>
		<li><a href="<%=CBEView.ADD_Admin%>">Create Admin</a></li>
		<li><a href="<%=CBEView.Add_Department%>">Add Department</a></li>


		<li><a href="<%=CBEView.VIEW_EMP_CTL%>">View Employee</a></li>
		<li><a href="<%=CBEView.VIEW_SALARY%>">Salary Report</a></li>
		<li><a href="<%=CBEView.VIEW_LEAVE%>">Leave Report</a></li>
		<li><a href="<%=CBEView.VIEW_TIMESHEET%>">TimeSheet Report</a></li>
		<li><a href="<%=CBEView.Department_List%>">View DepartMent</a></li>


		<li><a href="<%=CBEView.LOGOUT%>">Logout</a></li>
	</ul>


	<%
		} else if (adminUser == null && empUser == null && managerUser == null) {
	%>
	<ul>
		<li><a class="active" href="<%=CBEView.HOME%>">Home</a></li>
		<li><a href="<%=CBEView.EMP_LOGIN%>">Login</a></li>
		<li><a href="<%=CBEView.ADD_EMP%>">Register</a></li>

	</ul>


	<%
		} else if (adminUser == null && empUser != null && managerUser == null) {
	%>

	<ul>
		<li><a class="active"
			href="<%=CBEView.Edit_Emp%>?email=<%=empUser%>">View Profile</a></li>
        <li><a href="<%=CBEView.ADD_TimeSheet%>">Add TimeSheet</a></li>
		<li><a href="<%=CBEView.VIEW_TIMESHEET_Jsp2%>">View TimeSheet</a></li>
		<li><a href="<%=CBEView.ADD_LEAVE%>">Apply for Leave</a></li>
		<li><a href="<%=CBEView.VIEW_LEAVE_Jsp2%>">View Leave</a></li>
		

		<li><a href="<%=CBEView.LOGOUT%>">Logout</a></li>
	</ul>

	<%
		} else if (adminUser == null && empUser == null && managerUser != null) {
	%>

	<ul>
		<li><a class="active" href="<%=CBEView.ADD_PROPJECT%>">Create Project</a></li>
		<li><a  href="<%=CBEView.ProjectList%>">Project List</a></li>
		<li><a href="<%=CBEView.ADD_TimeSheet%>">Add TimeSheet</a></li>
			<li><a href="<%=CBEView.VIEW_TIMESHEET%>">TimeSheet Report</a></li>
				<li><a href="<%=CBEView.LOGOUT%>">Logout</a></li>

	</ul>
	<%
		}
	%>


</body>
</html>