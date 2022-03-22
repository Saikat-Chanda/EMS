<%@page import="ems.erp.util.CBEView"%>
<%@page import="ems.erp.model.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String email = request.getParameter("email");
String s1 = EmployeeModel.deleteEmp(email);
if(s1.equalsIgnoreCase("sucess")){
	response.sendRedirect(CBEView.VIEW_EMP);
}else{
	
	
	
}
%>
</body>
</html>