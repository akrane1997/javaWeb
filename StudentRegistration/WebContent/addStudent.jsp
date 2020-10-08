<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html; charset=UTF-8">
<title>Student Registration Form</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<p style="color: red">${RegStatus }</p>
	<div align="center">
		<h4 align="center">Student Registration Form</h4>
		<br>
		<br>
		<form id="1" action="SudentServlet" method="post">
		<input type="hidden" name="operation" value="addStud">
			<table>
				<tr>
					<th>Student Name:</th>
					<td><input type="text" name="studentname"></td>
				</tr>
				<tr>
					<th>Student Age:</th>
					<td><input type="text" name="studentage"></td>
				</tr>
				<tr>
					<th>Student Gender:</th>
					<td><input type="text" name="studentgender"></td>
				</tr>
				<tr>
					<th>Student Address:</th>
					<td><textarea rows=5 cols=20 name="studentaddress"></textarea></td>
				</tr>			
				<tr>
					<th>Student EmailId:</th>
					<td><input type="email" name="studentemailid"></td>
				</tr>
				<tr>
					<th>Student Password:</th>
					<td><input type="password" name="studentpassword"></td>
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