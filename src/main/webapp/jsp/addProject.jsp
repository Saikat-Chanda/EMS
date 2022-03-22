<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="../jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" type="text/css" href="../css/home.css">
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
	%>
	<%
		if (msg == null) {

		} else {
	%>
	<h2 style="color: green;"><%=msg%></h2>

	<%
		}
	%>

	<div class="login_form" style="margin: 80px; margin-left: 430px;">

		<form action="<%=CBEView.ADD_PROPJECT%>" method="post">

			<input type="text" placeholder="Enter the Project Name" name="pname">
			
			 <select name="pstatus">
				<option value="#">Project Status</option>
				<option value="Pending">In Process</option>
				<option value="Approved">Finish</option>
				<option value="Rejected">New</option>
			</select>
			
			<input type="text" placeholder="Enter the Project Description" name="des">
			
			<input type="text" placeholder="Enter the Project Cost" name="cost">
			
				<input type="text" placeholder="Assign To.." name = "assignTo">
			
			<input type="text" placeholder="Department" name="department">

			

			<button type="submit">Submit</button>

		</form>

	</div>

</body>
<%@include file="../jsp/footer.jsp"%>
</html>