<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" type="text/css" href="../css/home.css">
<%@include file="../jsp/header.jsp"%>
</head>
<body>
	<h1>Please enter your Login credentials</h1>
	
	<%
String invalid = (String)request.getAttribute("invalid");
if(invalid != null){
	%><h2 style="color: red;"><%=invalid %></h2><% 
}

%>

	<div class="mainDiv">

		<div class="login_form" style="margin: 135px; margin-left: 430px;">

			<form action="<%=CBEView.ADMIN_LOGIN_CTL%>" method="post">

				<input type="text" placeholder="Enter Username(email)..."
					name="uname"> 
					
					<select name="uType" id="uType" class="form-select" aria-label="Default select example">
					<option value="employee">Employee</option>
					<option value="manager">Manager</option>
					<option value="admin">Admin</option>
				</select>
				
				 <input type="password" placeholder="Enter Password" name="password">

				<button type="submit">Login</button>

			</form>

		</div>

	</div>

</body>
<%@include file="../jsp/footer.jsp"%>
</html>