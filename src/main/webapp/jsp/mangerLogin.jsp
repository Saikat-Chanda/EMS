<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/home.css">
	<link rel="stylesheet" type="text/css" href="../css/home.css">
<title>Insert title here</title>
</head>
	<%@include file="header.jsp" %>
</header>
<body>
<%
String invalid = (String)request.getAttribute("invalid");
if(invalid != null){
	%><h2 style="color: red;"><%=invalid %></h2><% 
}

%>

<h1>Manager Login</h1>
	<div class="mainDiv">

		<div class="login_form" style="margin: 135px; margin-left: 430px;">

			<form action="<%=CBEView.ADMIN_LOGIN_CTL%>" method="post">

				<input type="text" placeholder="Enter Username" name="uname">
				
				<input type="hidden" value="manager" name="utype">

				<input type="password" placeholder="Enter Password" name="password">

				<button type="submit">Login</button>

			</form>
			
		</div>

	</div>

</body>
<%@include file="footer.jsp" %>
</html>