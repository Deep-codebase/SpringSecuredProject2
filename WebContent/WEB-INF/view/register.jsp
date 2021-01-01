<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta charset="ISO-8859-1">

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head></head>

<body style="background-color: #ededed;">
<c:url value='/registerUser' var='registerUserVar' />
	<div style="background-color: #337ab7; height: 50px;"></div>
	<div class="container-fluid">
		<div class="row col-lg-4 col-lg-offset-4"
			style="margin-top: 80px; background-color: #fff; padding: 20px; border: solid 1px #ddd;">
			<form:form name="f" action="${registerUserVar }" modelAttribute="createnewUser" method="POST">
			<c:if test="${not empty registersuccess}">
				<p style="font-size: 20; color: #228B22;">${registersuccess}</p>
			</c:if>
				<br /><label>First Name</label>
				<br /> <form:input path='name' class="form-control mb-3" />
				<br /><label>Last Name</label>
				<br /> <form:input path='lastname' class="form-control"/> 
				<br /><label>Email</label>
				<br /> <form:input path='email' class="form-control"/>
				<br /><label>Password</label>
				<br /> <form:input path='password' class="form-control mb-3" />
				<br /><label>Role</label>
				<br /> <form:input path='role' class="form-control"/> 
				
				<br/><input name="submit" value="Register" class="btn btn-primary form-control" type="submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>