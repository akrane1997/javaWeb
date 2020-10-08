<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.mvc.bean.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<%
Student stud=(Student)session.getAttribute("studObj");
%>

<div align="center">
<h4 align="center">Update profile</h4>
	<br><br>
		<form id="1" action="SudentServlet" method="post">
		<input type="hidden" name="operation" value="updateStud">
			<table>
				<tr>
					<th>Student Id:</th>
					<td><input type="text" name="studid" value="<%=stud.getId()%>"></td>
				</tr>
				<tr>
					<th>Student Name:</th>
					<td><input type="text" name="studentname" value="<%=stud.getName()%>"></td>
				</tr>
				<tr>
					<th>Student Age:</th>
					<td><input type="text" name="studentage" value="<%=stud.getAge()%>"></td>
				</tr>
				<tr>
					<th>Student Gender:</th>
					<td><input type="text" name="studentgender" value="<%=stud.getGender()%>"></td>
				</tr>
				<tr>
					<th>Student Address:</th>
					<td><textarea rows=5 cols=20 name="studentaddress" value="<%=stud.getAddress()%>"></textarea></td>
				</tr>			
				<tr>
					<th>Student EmailId:</th>
					<td><input type="email" name="studentemailid" value="<%=stud.getEmail()%>"></td>
				</tr>
				<tr>
					<th>Student Password:</th>
					<td><input type="password" name="studentpassword" value="<%=stud.getPassword()%>"></td>
				</tr>
					<td><input type="submit" value="Update Profile"></td>
					<td><input type="reset" value="Cancel"></td>
				</tr>
			</table>
       </form>
       </div>
</body>
</html>