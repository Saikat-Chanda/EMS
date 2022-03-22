<%@page import="ems.erp.model.ReportsModel"%>
<%@page import="ems.erp.beans.Leave"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" type="text/css" href="../css/home.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="../jsp/header.jsp"%>
</head>
<body>
	<%
		String empSession = (String) session.getAttribute("empUser");
	%>
	<%
		String msg = (String) request.getAttribute("msg");
		String editMsg = (String) request.getAttribute("editMsg");
		Leave leave = ReportsModel.editLeave(editMsg);
		if (msg == null) {

		} else {
	%>
	<h2 style="color: green;"><%=msg%></h2>

	<%
		}
	%>

	<%
		if (empSession == null) {
	%>
	<h3>Add Leave</h3>
	<%
		if (editMsg == null) {
	%>
	<div class="login_form" style="margin: 80px; margin-left: 430px;">

		<form action="<%=CBEView.ADD_LEAVE%>" method="post">
			<input type="text" placeholder="Enter Employee's Email" name="email">
			<textarea name="des">Enter the Leave Description...</textarea>
			<input type="text" placeholder="From Date" name="fdate"> <input
				type="text" placeholder="To Date" name="tdate"> <select
				name="lstatus">
				<option value="#">Leave Status</option>
				<option value="Pending">Pending</option>
				<option value="Approved">Approved</option>
				<option value="Rejected">Rejected</option>
			</select>
			<button type="submit">Submit</button>
		</form>
	</div>
	<%
		} else {
	%>

	<div class="login_form" style="margin: 80px; margin-left: 430px;">

		<form action="<%=CBEView.ADD_LEAVE%>" method="post">
			<input type="hidden" name="editMsgLeave" value="<%=editMsg%>">
			<input type="text" placeholder="Enter Employee's Email" name="email"
				value="<%=leave.getEmail()%>">
			<textarea name="des"><%=leave.getDescription()%></textarea>
			<input type="text" placeholder="From Date" name="fdate"
				value="<%=leave.getFromDate()%>"> <input type="text"
				placeholder="To Date" name="tdate" value="<%=leave.getToDate()%>">
			<select name="lstatus">
				<option value="<%=leave.getStatus()%>"><%=leave.getStatus()%></option>
				<option value="Pending">Pending</option>
				<option value="Approved">Approved</option>
				<option value="Rejected">Rejected</option>
			</select>
			<button type="submit">Submit</button>
		</form>
	</div>

	<%
		}
		} else {
	%>

	<div class="login_form" style="margin: 80px; margin-left: 430px;">

		<form action="<%=CBEView.ADD_LEAVE%>" method="post">

			<input type="text" name="email" value="<%=empSession%>">



			<textarea name="des">Enter the Leave Description...</textarea>

			<input type="text" placeholder="From Date" name="fdate"> <input
				type="text" placeholder="To Date" name="tdate"> <select
				name="lstatus">
				<option value="Request">Request</option>
			</select>

			<button type="submit">Submit</button>

		</form>

	</div>

	<%
		}
	%>

</body>
<%@include file="../jsp/footer.jsp"%>
</html>