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
<title>Insert title here</title>
<%
String managerUser=(String)session.getAttribute("managerUser");
System.out.println(managerUser);
if(managerUser != null){
	%> <jsp:include page="../jsp/header.jsp"/><% 
}%>

</head>
<body>

<div class="home-content-wrapper">
		<div class="overlay-box">
			<div class="container">
				<div class="welcome-text">Hiiii <%= managerUser%> WELCOME TO <br/>Employee Management System Project in Java</div>	
			</div>
		</div>	
</div>



</body>
<%@include file="../jsp/footer.jsp" %>
</html>