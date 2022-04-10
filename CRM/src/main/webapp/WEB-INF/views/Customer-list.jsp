<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>

<html>

<body bgcolor="aqua">

	<div id="wrapper">
		<div id="header">
			<h2>Customer Relationship Management</h2>
		</div>
	</div>
	<div id="container">

		<div id="content">
			<!-- put new button: Add Customer -->

			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />


			<!-- add our html table here -->
			<table border="2">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->

				<c:forEach var="tempCustomer" items="${listcustomer}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>

						<td>
							<!-- DIsplay the Update Link --> 
							
							<a href="${updateLink}">Update</a>
							<a href="${deleteLink}"
							onclick="if(!(confirm('Are you Sure you want to delete this Customer?'))) return false">
								Delete </a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
