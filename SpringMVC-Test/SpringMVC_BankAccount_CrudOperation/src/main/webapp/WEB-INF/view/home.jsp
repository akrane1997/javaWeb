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
<title>Bank Account Details</title>
</head>
<body>
	<div class="container" align="center">
	<h3>Bank Account Details List</h3>
		<h5>
			<a href="newBankAccount"><button>New Bank Account</button></a>
		</h5>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Account No</th>
					<th scope="col">Account Holder Name</th>
					<th scope="col">Account Holder Address</th>
					<th scope="col">Account Balance</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bank" items="${listBank}">
					<tr>
						<td>${bank.account_No}</td>
						<td>${bank.account_Holder_Name}</td>
						<td>${bank.account_Holder_Address}</td>
						<td>@${bank.balance}</td>
						<td><a href="DepositAmount?account_No=${bank.account_No}"><button>Deposit </button></a>
						<a href="WithdrawalAmount?account_No=${bank.account_No}"><button>Withdrawal </button></a>
						<a href="editBankAccount?account_No=${bank.account_No}"><button>Update</button></a>
							<a href="deleteBankAccount?account_No=${bank.account_No}"><button>Delete
									Account</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
			crossorigin="anonymous"></script>
	</div>
</body>
</html>