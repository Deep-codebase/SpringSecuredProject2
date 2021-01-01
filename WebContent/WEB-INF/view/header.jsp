<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<title>Bootstrap Example</title>


<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script> 
<!-- <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.js"/> -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.js"></script>
<!-- <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/> -->
<link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.css"/>	
		
	<script type="text/javascript">
	
	</script>
	
</head>
<body>
	<c:url value='/company/showcompanyform.html' var="companyForm"/>
	<c:url value='/vendors/showVendor.html' var="vendorForm"/>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand/logo -->
		<a class="navbar-brand" href="#"> <!-- <img src="bird.jpg" alt="logo" style="width:40px;"> -->
		</a>

		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href="/SpringProject/customer/list">Customer List</a></li>
			<li class="nav-item"><a class="nav-link" href="${companyForm }">Add
					Companies</a></li>
			<li class="nav-item"><a class="nav-link" href="${vendorForm }">Vendor Details</a></li>
		</ul>
		<c:url value='/logout' var="logoutVar"/>
		<ul class="navbar-nav  ml-auto">
		<li class="nav-item"><form action="${logoutVar}" method="POST">
			<input id="logoutbtn" type="submit" value="Logout" class="btn btn-primary"/>
		
		</form>
		</li>
		</ul>
	</nav>

</body>
</html>
