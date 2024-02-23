<%@page import="com.jsp.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Table</title>
<style type="text/css">
div {
	margin-top: 140px;
	height: auto;
	width: 400px;
	border: 2px bisque;
	background: linear-gradient(yellow, green);
	border-radius: 10px;
	border-spacing: 2px;
	box-shadow: 20px;
	font-family: 'Times New Roman', Times, serif;
}
</style>
</head>
<body style="background: radial-gradient(gold, gold);">
	<%
	Employee emp = (Employee) session.getAttribute("employeedetails");
	%>
	<center>
		<div>

			<form action="update">
				<input value=<%=emp.getEmpid()%> name="empid" hidden="true"> <br> <br>
				<input value=<%=emp.getEmpName()%> name="empname"> <br>
				<br> <input value=<%=emp.getEmpSalary()%> name="empsalary">
				<br> <br> <input value=<%=emp.getEmpdeptno()%>
					name="empdeptno"><br> <br> <input type="submit">
			</form>

		</div>
	</center>
</body>
</html>