<%@page import="ems.erp.model.EmployeeModel"%>
<%@page import="ems.erp.beans.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/common.css">
<title>View Employee</title>
</head>
<%@include file="../jsp/header.jsp"%>
<body>
	<h3>View Employee</h3>
	<%
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList = EmployeeModel.viewEmp();

		String msg = (String) request.getAttribute("msg");
		String updateMsg = (String) request.getAttribute("updateMsg");

		String errorMsg = (String) request.getAttribute("errorMsg");
		if (msg == null) {

		} else {
	%>
	<h2 style="color: green;"><%=msg%></h2>

	<%
		}
	%>

	<!-- Update msg -->

	<%
		if (updateMsg == null) {

		} else {
	%>
	<h2 style="color: green;"><%=updateMsg%></h2>

	<%
		}
	%>

	<table id="emp_table">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			for (int i = 0; i < empList.size(); i++) {
		%>
		<tr>
			<td><%=empList.get(i).getFname() + "  " + empList.get(i).getLname()%></td>
			<td><%=empList.get(i).getEmail()%></td>
			<%
				String email = empList.get(i).getEmail();
			%>
			<td><a href="<%=CBEView.Edit_Emp%>?email=<%=email%>">Edit</a></td>

			<td><a href="<%=CBEView.DELETE_EMP%>?email=<%=email%>">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>

</body>

<%@include file="../jsp/footer.jsp"%>
</html>