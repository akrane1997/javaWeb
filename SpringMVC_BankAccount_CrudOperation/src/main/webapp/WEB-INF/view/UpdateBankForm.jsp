<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="spring.mvc.model.Bank"%>
	
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
		<h2>Add New Bank Account</h2>
		<form action="saveBankAccount" method="post" modelAttribute="bank">
		<div class="form-group row">
				<label for="inputText" class="col-sm-2 col-form-label">Account No</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="accountno"
						value="" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputText" class="col-sm-2 col-form-label">Account
					Holder Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name"
						placeholder="Name" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputText" class="col-sm-2 col-form-label">Address</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="address"
						placeholder="Address" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputText" class="col-sm-2 col-form-label">Minimum
					Balance</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="10000"
						disabled>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-10 offset-sm-2">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>
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