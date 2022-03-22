<%@page import="ems.erp.util.CBEView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log out</title>
<style type="text/css">
.back-img{
background : url("images/back.jpg");
height : 600px;
}
</style>
</head>


<body class="container-fluid back-img">
<%
session.getAttribute("adminUser");
session.invalidate();
request.getRequestDispatcher(CBEView.HOME2).forward(request, response);

%>

</body>
</html>