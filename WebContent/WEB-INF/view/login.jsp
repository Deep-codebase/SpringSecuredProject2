<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #ededed;">
	<c:url value='/login' var='loginvar' />
	
	<div style="background-color: #337ab7; height: 50px;"></div>
	<div class="container-fluid">
		<div class="row col-lg-4 col-lg-offset-4"
			style="margin-top: 80px; background-color: #fff; padding: 20px; border: solid 1px #ddd;">
			<form name="f" action="${loginvar}" method="POST">
				<!-- <h3 align="center" class="form-signin-heading">Login</h3> -->
				<c:if test="${param.error!=null}">
					<div align="center">
						<p style="font-size: 20; color: #FF1C19;">Invalid Username or Password</p>
					</div>
				</c:if>
				<br /> <input type='text' name='j_username' class="form-control mb-3" />
				<br /> <input type='password' name='j_password'
					class="form-control"/> 
				
				<br/><input name="submit" value="Login" class="btn btn-primary form-control" type="submit"/>
				
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					
			</form>
			<c:url value='/register' var='registerVar' />
			<br/><a href="${registerVar}"><input name="wer" value="Create Account" class="btn btn-primary form-control" type="button"/></a>
		</div>
	</div>

</body>
</html>