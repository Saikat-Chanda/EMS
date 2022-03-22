<%@page import="ems.erp.model.ReportsModel"%>
<%@page import="ems.erp.beans.Salary"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" type="text/css" href="../css/home.css">
<title>Insert title here</title>
<%@include file="../jsp/header.jsp"%>
</head>
<body>
	<h3>Add Salary</h3>
	<%
			String msg = (String) request.getAttribute("msg");
	       String editMsg = (String)request.getAttribute("editMsg");
	       System.out.println("Add salary jsp "+editMsg);
	       Salary sal = ReportsModel.editSalaryGet(editMsg);
				if (msg == null) {

				} else {
		%>
		<h2 style="color: green;"><%=msg%></h2>
	
		<%
			}
				
		if(editMsg == null){		
		%>
  
	<div class="login_form" style="margin: 80px; margin-left: 430px;">

		<form action="<%=CBEView.ADD_SALARY%>" method="post">

			<input type="text" placeholder="Enter Employee's Email" name="email">
            <input type="hidden" name="temp" value="add">
			<select name="month">
			    <option value="#">Select Month</option>
				<option value="January">January</option>
				<option value="February">February</option>
				<option value="March">March</option>
				<option value="April">April</option>
				<option value="May">May</option>
				<option value="June">June</option>
				<option value="July">July</option>
				<option value="August">August</option>
				<option value="September">September</option>
				<option value="October">October</option>
				<option value="November">November</option>
				<option value="December">December</option>
			</select>
			
			<select name="year">
			    <option value="<%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %>">	<%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %></option>
				
			</select>

			 <input type="text" placeholder="Enter Amount" name="amount">

			<button type="submit">Submit</button>
          
		</form>
		
		</div>
		
		<%}else{ %>
		
			<div class="login_form" style="margin: 80px; margin-left: 430px;">

		<form action="<%=CBEView.ADD_SALARY%>" method="post">

			<input type="text" placeholder="Enter Employee's Email" name="email" value="<%=sal.getEmail()%>">
            <input type="hidden" name="editMsggggg" value="<%=editMsg%>">
			<select name="month">
			    <option value="<%=sal.getMonth() %>"><%=sal.getMonth() %></option>
				<option value="January">January</option>
				<option value="February">February</option>
				<option value="March">March</option>
				<option value="April">April</option>
				<option value="May">May</option>
				<option value="June">June</option>
				<option value="July">July</option>
				<option value="August">August</option>
				<option value="September">September</option>
				<option value="October">October</option>
				<option value="November">November</option>
				<option value="December">December</option>
			</select>
			
			<select name="year">
			    <option value="<%=sal.getYear()%>">	<%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %></option>
				
			</select>

			 <input type="text" placeholder="Enter Amount" name="amount" value="<%=sal.getAmount()%>">

			<button type="submit">Submit</button>
          
		</form>
		
		</div>
		
		<%} %>

	

</body>
<%@include file="../jsp/footer.jsp"%>
</html>