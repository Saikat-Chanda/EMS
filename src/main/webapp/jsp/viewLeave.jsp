<%@page import="ems.erp.model.ReportsModel"%>
<%@page import="ems.erp.beans.Leave"%>
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
	<h3>View Leave</h3>
	<%
		ArrayList<Leave> leaveList = new ArrayList<Leave>();
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
	<%
		if (empSession == null) {

			leaveList = ReportsModel.viewLeave();
	%>
	<table id="emp_table">
		<tr>
			<th>Email</th>
			<th>Description</th>
			<th>From Date</th>
			<th>To Date</th>
			<th>Status</th>
			<th>Edit</th>
		
		</tr>
		<%
			for (int i = 0; i < leaveList.size(); i++) {
		%>
		<tr>

			<td><%=leaveList.get(i).getEmail()%></td>
			<td><%=leaveList.get(i).getDescription()%></td>
			<td><%=leaveList.get(i).getFromDate()%></td>
			<td><%=leaveList.get(i).getToDate()%></td>
			<td><%=leaveList.get(i).getStatus()%></td>
			<%
				String email = leaveList.get(i).getEmail();
						int lid = leaveList.get(i).getLid();
			%>
			<td><a href="<%=CBEView.EDIT_LEAVE%>?email=<%=lid%>&op=edit">Edit</a></td>
		
		</tr>
		<%
			}
		%>
	</table>
	<%
		} else {
			leaveList = ReportsModel.viewLeave(empSession);
	%>
	<table id="emp_table">
		<tr>
			<th>Email</th>
			<th>Description</th>
			<th>From Date</th>
			<th>To Date</th>
			<th>Status</th>

		</tr>
		<%
			for (int i = 0; i < leaveList.size(); i++) {
		%>
		<tr>
			<td><%=leaveList.get(i).getEmail()%></td>
			<td><%=leaveList.get(i).getDescription()%></td>
			<td><%=leaveList.get(i).getFromDate()%></td>
			<td><%=leaveList.get(i).getToDate()%></td>
			<td><%=leaveList.get(i).getStatus()%></td>

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