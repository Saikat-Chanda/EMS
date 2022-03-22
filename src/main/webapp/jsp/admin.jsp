<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management System</title>
<%
String adminUser=(String)session.getAttribute("adminUser");
System.out.println(adminUser);
if(adminUser != null){
	%> <jsp:include page="../jsp/header.jsp"/><% 
}%>

</head>
<body>
<div class="home-content-wrapper">
		<div class="overlay-box">
			<div class="container">
				<div class="welcome-text">Welcome <%= adminUser%> To <br/>Employee Management System</div>	
			</div>
		</div>	
</div>



</body>
<%@include file="../jsp/footer.jsp" %>
</html>