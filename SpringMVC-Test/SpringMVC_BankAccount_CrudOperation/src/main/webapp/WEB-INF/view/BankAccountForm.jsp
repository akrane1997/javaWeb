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
<style>
.bs-example {
	margin: 20px;
}
</style>
<title>Bank Account Form</title>
</head>
<body>
	<div class="bs-example">

		<form:form action="saveBankAccount" method="post"
			modelAttribute="bank">
			<c:choose>
				<c:when test="${empty bank.account_Holder_Name}">
					<h1>Add Account Details</h1>
					<br />
				</c:when>
				<c:otherwise>
					<h1>Update Account Details</h1>
					<br />
				</c:otherwise>
			</c:choose>
			<c:if test="${!empty bank.account_Holder_Name}">
				<div class="form-group row">
					<form:label path="Account_No" class="col-sm-2 col-form-label">Account No:</form:label>
					<div class="col-sm-10">
						<form:input type="text" path="Account_No" class="form-control"
							name="Account_No" placeholder="Name" required="true"></form:input>
					</div>
				</div>
			</c:if>
			<div class="form-group row">
				<form:label path="Account_Holder_Name"
					class="col-sm-2 col-form-label">Account
					Holder Name:</form:label>
				<div class="col-sm-10">
					<form:input type="text" path="Account_Holder_Name"
						class="form-control" name="Account_Holder_Name" placeholder="Name"
						required="true"></form:input>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="Account_Holder_Address"
					class="col-sm-2 col-form-label">Address:</form:label>
				<div class="col-sm-10">
					<form:input type="text" path="Account_Holder_Address"
						class="form-control" name="Account_Holder_Address"
						placeholder="Address" required="true"></form:input>
				</div>
			</div>
			<c:choose>
				<c:when test="${empty bank.account_Holder_Name}">
				<div class="form-group row">
					<form:label path="balance" class="col-sm-2 col-form-label">Minimum
					Balance</form:label>
					<div class="col-sm-10">
						<form:input type="text" path="balance" class="form-control"
							name="balance" placeholder="10000" value="10000" required="true"
							disable="true"></form:input>
					</div>
				</div>
			</c:when>
				<c:otherwise>
				<div class="form-group row">
					<form:label path="balance" class="col-sm-2 col-form-label">Available
					Balance</form:label>
					<div class="col-sm-10">
						<form:input type="text" path="balance" class="form-control"
							name="balance" required="true"
							disable="true"></form:input>
					</div>
				</div>
				</c:otherwise>
			</c:choose>
			
			<c:if test="${!empty bank.account_Holder_Name}">
				<div class="form-group row">
					<div class="col-sm-10 offset-sm-2">
						<button type="submit" class="btn btn-primary">update
							Account</button>
					</div>
				</div>
			</c:if>

			<c:if test="${empty bank.account_Holder_Name}">
				<div class="form-group row">
					<div class="col-sm-10 offset-sm-2">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>
			</c:if>
		</form:form>
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