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
	<%
		String empSession = (String) session.getAttribute("empUser");
	%>
	<h3>Department List</h3>
	<%
		ArrayList<String> alist = new ArrayList<String>();
	   alist = AdminLoginModel.DeptList();
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
			<th>Depatment Name</th>
		
		</tr>
		<%
			for (int i = 0; i < alist.size(); i++) {
		%>
		<tr>

			<td><%=alist.get(i)%></td>
			<td><a href="<%=CBEView.DEPT_EMP%>?dname=<%=alist.get(i)%>&op=edit">View Employee</a></td>
		
		</tr>
		<%
			}
		%>
	</table>
	
</body>
<%@include file="../jsp/footer.jsp"%>
</html>