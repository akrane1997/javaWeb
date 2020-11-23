<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<div align="center">
	<div class="bs-example">
		<h1>Add New OrderDetail</h1>
		<form:form action="saveOrderDetail" method="post"
			modelAttribute="orderDetail">
			<c:if test="${!empty orderDetail.product_name}">
			<div class="form-group row">
				<form:label path="product_id" name="question_Id"
					class="col-sm-2 col-form-label">Product Id:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" name="product_id"
						path="product_id" required="true"></form:input>
				</div>
			</div>
			</c:if>
			<div class="form-group row">
				<form:label path="product_name" class="col-sm-2 col-form-label">Product Name:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" path="product_name"
						required="true"></form:input>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="product_company" class="col-sm-2 col-form-label">Product Company:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" path="product_company"
						required="true"></form:input>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="price" class="col-sm-2 col-form-label">Price:</form:label>
				<div class="col-sm-10">
					<form:input class="form-control" path="price" required="true"></form:input>
				</div>
			</div>
			<c:if test="${!empty orderDetail.product_name}">
					<div class="form-group row">
						<div class="col-sm-10 offset-sm-2">
							<button type="submit" class="btn btn-primary">update
								Order</button>
						</div>
					</div>
				</c:if>
				<c:if test="${empty orderDetail.product_name}">
					<div class="form-group row">
						<div class="col-sm-10 offset-sm-2">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>
				</c:if>
		</form:form>
		</div>
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