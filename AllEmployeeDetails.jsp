<%@page import="com.jsp.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp Details</title>
<style>
div {
	margin-top: 100px;
	height: auto;
	width: 450px;
	border: 2px bisque;
	background: linear-gradient(yellow, green);
	border-radius: 10px;
	border-spacing: 2px;
	font-family: 'Times New Roman', Times, serif;
}
</style>
</head>
<body style="background: radial-gradient(green, gold);">
	<form action="allemployeesBySalaryOrDeptno" method="post">
		<center>
			<input placeholder="Enter Deptno or Salary " name="dept"><br>
			<br> <input type="submit">
	</form>
	<div>

		<table border="5px">
			<tr>


				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee Salary</th>
				<th>Employee Deptno</th>
				<th>Update</th>
				<th>Delete</th>

			</tr>



			<%
			List<Employee> e = (List<Employee>) session.getAttribute("listofEmp");

			for (Employee employee : e) {
			%>
			<tr>
				<td><%=employee.getEmpid()%></td>
				<td><%=employee.getEmpName()%></td>
				<td><%=employee.getEmpSalary()%></td>
				<td><%=employee.getEmpdeptno()%></td>
				<td>
					<form action="getempid" method="post">
						<input value=<%=employee.getEmpid()%> hidden="true" name="empid">
						 <input	type="submit" value="Update">
					</form>
				</td>
				<td><input type="submit" value="Delete"></td>
			</tr>
			<%
			}
			%>



		</table>

	</div>
	</center>
</body>
</html>