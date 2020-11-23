<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>Insert title here</title>

</head>
<body>
	<div class="container" align="center">
		<h1>OrderDetail List</h1>
		<h3>
			<a href="newOrder">New Product</a>
		</h3>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Product Id</th>
					<th scope="col">Product Name</th>
					<th scope="col">Product Company</th>
					<th scope="col">Price</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="orderDetail" items="${listOrderDetail}">
					<tr>
						<td>${orderDetail.product_id}</td>
						<td>${orderDetail.product_name}</td>
						<td>${orderDetail.product_company}</td>
						<td>${orderDetail.price}</td>
						<td><a href="editOrder?product_id=${orderDetail.product_id}">Edit</a> <a
							href="deleteOrder?product_id=${orderDetail.product_id}">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>