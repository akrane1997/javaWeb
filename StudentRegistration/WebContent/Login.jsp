<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
	<p style="color: red">${status }</p>
	

	<div align="center">
		<h2>Welcome To Login Page</h2>
		<br> <br> <br> <br>

		<form id="1" action="LoginServlet" method="post">
			<input type="hidden" name="operation" value="Login">
			<tr>
				<td><input type="radio" name="type" value="student">Student</td>
				<td><input type="radio" name="type" value="teacher">Teacher</td>
			</tr>

			<table border=1>

				<tr>
					<th>Email Id:</th>
					<td><input type="email" name="emailId"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
					<td><a href="addStudent.jsp">Register Here</a></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>
