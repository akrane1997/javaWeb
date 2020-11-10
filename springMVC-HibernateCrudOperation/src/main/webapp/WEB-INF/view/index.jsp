<html>
<body>
<h2>Hello World!</h2>
<div align="center">
		<h1>Employee List</h1>
		<h3>
			<a href="newEmployee">New Employee</a>
		</h3>
		<table border="1">

			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>

			<c:forEach var="employee" items="${listEmployee}">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.address}</td>
					<td>${employee.email}</td>
					<td>${employee.password}</td>
					<td><a href="editEmployee?id=${employee.id}">Edit</a> <a
						href="deleteEmployee?id=${employee.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
