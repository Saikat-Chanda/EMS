<%@page import="ems.erp.beans.Project"%>
<%@page import="ems.erp.model.ManagerModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<h3>Project List</h3>
	<%
	ArrayList<Project> plist = new ArrayList<Project>();
	   plist = ManagerModel.viewProject();
		String msg = (String) request.getAttribute("msg");
	
		if (msg == null) {

		} else {
	%>
	<h2 style="color: green;"><%=msg%></h2>

	<%
		}
	%>

	<!-- Update msg -->


	<table id="emp_table">
		<tr>
			<th>Project Name</th>
			<th>Project Status</th>
			<th>Project Description</th>
			<th>Project Cost</th>
		    <th>Assign To</th>
		    <th>Department</th>
		</tr>
		<%
			for (int i = 0; i < plist.size(); i++) {
		%>
		<tr>

			<td><%=plist.get(i).getPname()%></td>
			<td><%=plist.get(i).getPstatus()%></td>
			<td><%=plist.get(i).getDescription()%></td>
			<td><%=plist.get(i).getCost()%></td>
			<td><%=plist.get(i).getAssignTo()%></td>
			<td><%=plist.get(i).getDepartment()%></td>
			
			
		
		</tr>
		<%
			}
		%>
	</table>
	
</body>
<%@include file="../jsp/footer.jsp"%>
</html>