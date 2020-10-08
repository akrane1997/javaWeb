<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="color:red">${status }</p>

	<div align="center">
		<h2>Welcome To Login Page</h2>
		<br> <br> <br> <br>
								
		<form id="1" action="LoginServlet" method="post">
		<input type="hidden" name="operation" value="Login">
			<table border=2>
				<tr>
					<th>User Name:</th>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>