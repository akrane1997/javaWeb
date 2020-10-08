<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String student=(String)session.getAttribute("student");
String teacher=(String)session.getAttribute("teacher");
%>
<div id="header">																																																																									
		<div class="login">
			<div class="links">
			<% if(student==null && teacher==null) 
			{%>
			<a href="Login.jsp">Login</a> <%} %>
			 <a href="addCustomer.jsp">Registration</a>
			 </div>
		</div>
		<ul id="menu">
			<li><a href="Home.jsp">Home page</a></li>                                                                                                                                                                                                                                                                                                                                                  
			<li><a href="HotelServlet?operation=showHotels">Hotels</a></li>
			<li><a href="Search.jsp">Search</a></li>
			
			<%if(teacher!=null && student==null) {%>
			<li><a href="addHotel.jsp">Add Hotels</a></li>
			<!-- <li><a href="CustomerServlet">Show Customers</a></li> -->
			<li><a href="ChangePass.jsp">Change Password</a>
			<li><a href="BookingServlet?operation=showBills">Show Bill</a></li>
			<li><a href="CustomerServlet?operation=showFeedback">Add Hotels</a></li>
			<%}%>
			
			<% if(teacher==null && student!=null) {%>
			<!-- <li><a href="Feedback.jsp">Give Feedback</a></li> -->
			<li><a href="BookingServlet">Show Booking</a></li>
			<li><a href="CustomerServlet?operation=edit">Update Profile</a></li>
			<%} %>
			
			<% if(teacher!=null || student!=null) {%>
			<li><a href="LoginServlet">Log Out</a>
			<%} %>
			</ul>
	</div>
</body>
</html>