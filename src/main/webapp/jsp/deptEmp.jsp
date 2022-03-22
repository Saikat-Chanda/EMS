<%@page import="java.util.ArrayList"%>
<%@page import="ems.erp.model.AdminLoginModel"%>
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

	<h3>Employee List</h3>
	<%
	String dname = (String) request.getAttribute("dname");
	ArrayList<String> elist = new ArrayList<String>();
	   elist = AdminLoginModel.DeptEmpList(dname);
		

	%>

	<!-- Update msg -->


	<table id="emp_table">
		<tr>
			<th>Employee Name</th>
		
		</tr>
		<%
			for (int i = 0; i < elist.size(); i++) {
		%>
		<tr>

			<td><%=elist.get(i)%></td>
			
		
		</tr>
		<%
			}
		%>
	</table>
	
</body>
<%@include file="../jsp/footer.jsp"%>
</html>