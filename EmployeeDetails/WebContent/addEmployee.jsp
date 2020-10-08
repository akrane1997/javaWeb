<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="color: red">${RegStatus }</p>
	<div align="center">
		<h4 align="center">Employee Registration Form</h4>
		<br>
		<br>
		<form id="1" action="EmployeeServlet" method="post">
		<input type="hidden" name="operation" value="addEmployee">
			<table>
				<tr>
					<th>Employee Name:</th>
					<td><input type="text" name="employeeName"></td>
				</tr>
				<tr>
					<th>Employee EmailId:</th>
					<td><input type="email" name="employeeemail"></td>
				</tr>
				<tr>
					<th>Employee Address:</th>
					<td><textarea rows=5 cols=20 name="employeeaddress"></textarea></td>
				</tr>			
				<tr>
					<td><input type="submit" value="Register"></td>
					<td><input type="reset" value="Cancel"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>