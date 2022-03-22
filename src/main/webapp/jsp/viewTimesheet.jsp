<%@page import="ems.erp.model.ReportsModel"%>
<%@page import="ems.erp.beans.Timesheet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="../css/common.css">
<%@include file="../jsp/header.jsp"%>
</head>
<body>
	<%
		String empSession = (String) session.getAttribute("empUser");
	%>
	<%
		if (empSession == null) {
	%>
	<h3>View TimeSheet</h3>
	<%
		ArrayList<Timesheet> tList = new ArrayList<Timesheet>();
			tList = ReportsModel.viewTimesheet();

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
			<th>Email</th>
			<th>Work Tittle</th>
			<th>Description</th>
			<th>Hours</th>
			<th>Dater</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			for (int i = 0; i < tList.size(); i++) {
		%>
		<tr>
			<td><%=tList.get(i).getEmail()%></td>
			<td><%=tList.get(i).getWorkTittle()%></td>
			<td><%=tList.get(i).getDescription()%></td>
			<td><%=tList.get(i).getHours()%></td>
			<td><%=tList.get(i).getDate()%></td>
			<%
				String email = tList.get(i).getEmail();
			%>
			<td><a href="<%=CBEView.EDIT_TSHEET%>?email=<%=email%>&op=edit">Edit</a></td>
			<td><a
				href="<%=CBEView.EDIT_TSHEET%>?delEmail=<%=email%>&op=delete">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} else {
	%>
	<h3>View User TimeSheet</h3>
	<%
		ArrayList<Timesheet> tList = new ArrayList<Timesheet>();
			tList = ReportsModel.viewTimesheet(empSession);
	%>
	<table id="emp_table">
		<tr>
			<th>Email</th>
			<th>Work Tittle</th>
			<th>Description</th>
			<th>Hours</th>
			<th>Dater</th>
		</tr>
		<%
			for (int i = 0; i < tList.size(); i++) {
		%>
		<tr>
			<td><%=tList.get(i).getEmail()%></td>
			<td><%=tList.get(i).getWorkTittle()%></td>
			<td><%=tList.get(i).getDescription()%></td>
			<td><%=tList.get(i).getHours()%></td>
			<td><%=tList.get(i).getDate()%></td>
			<%
				String email = tList.get(i).getEmail();
			%>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
</body>
<%@include file="../jsp/footer.jsp"%>
</html>