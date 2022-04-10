<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

<title>Save Customer</title>
</head>

<body bgcolor="aqua">
	<div id="wrapper">
		<div id="header">
			<h2> CUSTOMER REGISTERATION</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Customer</h3>



		<form:form action="save" modelAttribute="customer" method="POST">
			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />

			<table border="2">

				<tbody>
					<tr>
						<td><label>First name: </label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last name: </label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="Email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<hr>
		<a href="/CRM/customer/list">Back to List</a>
	</div>
</body>
</html>
