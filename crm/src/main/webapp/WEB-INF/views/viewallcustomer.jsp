<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<!-- HEAD -->
	<head>
		<title>Customer List</title>
		<!-- Referencing CSS -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	</head>
	<!-- BODY -->
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CUSTOMER RELATIONSHIP MANAGER</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
			<!-- on click calling spring container -->
				<input type="button" value="Add Customer" class="add-button" 
				onClick="window.location.href='showNewForm';return false;"/>
				<table>
					<tr>
						<!-- <th>ID</th> -->
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					<tr>
					<c:forEach var="tempCustomer" items="${Customers}">
						<c:url var="updateLink" value="/customer/showUpdateForm">
							<c:param name="id" value="${tempCustomer.id}"/>
						</c:url>
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="id" value="${tempCustomer.id}"/>
						</c:url>
						<tr>
							<%-- <td>${tempCustomer.id}</td> --%>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>
								<a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
	<!-- FOOTER -->
</html>