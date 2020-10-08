<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.mvc.Pojo.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 style="color: green">
		<b>${status}</b>
	</h3>
	<h3 style="color: red">
		<b>${empstatus}</b>
	</h3>

	<%
		List<Employee> elist = (List<Employee>) session.getAttribute("elist");
	%>

	<div align="center">
		<br> <br>
		<h2>Employee List</h2>
		<br> <br>
		<table border="1">
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee Email</th>
				<th>Employee Address</th>
				<th>Action</th>
			</tr>

			<%
				for (Employee e : elist) {
			%>
			<tr>
				<td><%=e.getEmpId()%></td>
				<td><%=e.getEmpName()%></td>
				<td><%=e.getEmpEmail()%></td>
				<td><%=e.getEmpAddress()%></td>

				<td><a
					href="EmployeeServlet?operation=edit&empId=<%=e.getEmpId()%>">Edit</a>
					<a href="EmployeeServlet?operation=delete&emplId=<%=e.getEmpId()%>">Delete|</a>
				</td>
			</tr>
			<%
				}
			%>


			<%-- <c:forEach var="e" items="${elist}">
				<tr>
					<td>${e.EmpId}</td>
					<td>${e.EmpName}</td>
					<td>${e.EmpEmail}</td>
					<td>${e.EmpAddress}</td>
					<td>${h.hotelPrice}</td>
					<td>
							<a href="EmployeeServlet?operation=delete&emplId=${e.EmpId}">Edit</a>
							<a href="EmployeeServlet?operation=edit&EmpId=${e.EmpId}">Delete|</a>
			</c:forEach> --%>
		</table>
	</div>
	
</body>
</html>