<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Employee</title>
</head>

<body>
	<c:url value="/customer/list" var="Customerlist" />
	<div class="container">
		<h3>Employee Directory</h3>
		<hr>
		<p class="h4 mb-4">Save Employee</p>

		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
			<c:if test="${not empty successsaving}">
				<p style="font-size: 20; color: #228B22; text-align: center;">${successsaving}</p>
			</c:if>
			<form:input path="firstName" class="form-control mb-4 col-4" placeholder="First name" />
			<form:input path="lastName" class="form-control mb-4 col-4" placeholder="Last name" />
			<form:input path="email" class="form-control mb-4 col-4" placeholder="Email" />
			<input type="submit" class="btn btn-primary col-4" value="Save" />


		</form:form>
		</hr>
		<c:url value="/customer/list" var="showlist" />
		<a style="margin-left: 50%;" href="${showlist}">Back to Employees
			List</a>
	</div>
</body>

</html>