<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.mvc.bean.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<%
		List<Student> Slist = (List<Student>) session.getAttribute("sList");
	%>
	<%
		String student = (String) session.getAttribute("student");
		String teacher = (String) session.getAttribute("teacher");
	%>

	<br>
	<br>
	<h2>Registered Students List:</h2>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Student Name</th>
			<th>Student Age</th>
			<th>Student Gender</th>
			<th>Student Address</th>
			<th>Student Email</th>
			<th>Action</th>
		</tr>
		<%
			for (Student s : slist) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getAge()%></td>
			<td><%=s.getGender()%></td>
			<td><%=s.getAddress()%></td>
			<td><%=s.getEmail()%></td>
			<td>
				<%
					if (student == null && teacher != null) {
				%> <a href="sudentServlet?operation=edit&id=<%=s.getId()%>">Edit</a>
				<a href="sudentServlet?operation=delete&id=<%=s.getId()%>">Delete|</a>


				<%
					}
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>