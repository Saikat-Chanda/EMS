<%@page import="ems.erp.model.ReportsModel"%>
<%@page import="ems.erp.beans.Salary"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/common.css">
<title>Insert title here</title>
<%@include file="../jsp/header.jsp"%>
</head>
<body>
<h3>View Salary</h3>
	<%
		ArrayList<Salary> salList = new ArrayList<Salary>();
		salList = ReportsModel.viewSalary();
		
		String msg = (String) request.getAttribute("msg");
		String updateMsg = (String) request.getAttribute("updateMsg");
		
		
		  String errorMsg = (String) request.getAttribute("errorMsg");
		if (msg == null ) {

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
	
	<%} %>

	<table id="emp_table">
		<tr>
			<th>Email</th>
			<th>Month</th>
			<th>Year</th>
			<th>Amount</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			for (int i = 0; i < salList.size(); i++) {
		%>
		<tr>
			<td><%=salList.get(i).getEmail()%></td>
			<td><%=salList.get(i).getMonth()%></td>
			<td><%=salList.get(i).getYear()%></td>
			<td><%=salList.get(i).getAmount()%></td>
			<%
				String email = salList.get(i).getEmail();
			%>
			<td><a href="<%=CBEView.EDIT_SAL%>?email=<%=email%>&op=edit">Edit</a></td>

			<td><a href="<%=CBEView.EDIT_SAL%>?emailDelete=<%=email%>&op=delete">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>


</body>
<%@include file="../jsp/footer.jsp"%>
</html>