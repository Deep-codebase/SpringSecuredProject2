<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>

<head>
<title>List Customers</title>

<!-- reference our style sheet -->

<%-- <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" /> --%>
<!-- <meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no"> -->

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script> 
<script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.js"/>
<!-- <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/> -->
<link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.css"/>
<!-- <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"> -->
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	</div>
	<script type="text/javascript">
		var namearray = [];
	</script>
	<div class="container">

		<div id="content">

			<div class="row">
				<div class="col-md-11">
					<h3 class="mt-3">Employee Directory</h3>
				</div>
				<div class="col-md-1"></div>
			</div>
			<hr>
			<c:url value="/customer/showFormForAdd" var="showformVar" />
			<a href="${showformVar}" class="btn btn-primary mb-3 btn-sm"> Add
				Employee </a>
			<table id="customerlisttable" class="table table-bordered table-striped display">
				<thead class="thead-dark">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<%-- <c:forEach var="tempCustomer" items="${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
						</td>
					</tr>

				</c:forEach> --%>
				</thead>
			</table>
			<script type="text/javascript">			    
			    $(document).ready(function () {
			    	var responsedata ='${customertablejson}';
			  	  var jsonData = JSON.parse(responsedata);
			  		$('#customerlisttable').DataTable({
			  		    "data": jsonData,
			  		    "columns": [
			  		      { "data": "firstName" },
			  		      { "data": "lastName" },
			  		      { "data": "email" },
	
			  		     /*  {"data": null,
			  		    	defaultContent: '<a href="/SpringProject/customer/showFormForUpdate?customerId=1" class="editor_edit">Edit</a> / <a href="" class="editor_remove">Delete</a>'
			  		      } */
			  		      {
			  		    	  "data" : "id",
			  		    	   render: function (value) {
			  		    		 return '<a href="/SpringProject/customer/showFormForUpdate?customerId='+value+'" class="editor_edit">Edit</a> / <a href="" class="editor_remove">Delete</a>'
	                           }
			  		      }
			  		    ]
			  		});
			    });
			
			    editor = new $.fn.dataTable.Editor( {
			        "ajax": "../php/staff.php",
			        "table": "#customerlisttable",
			        "fields": [ {
			                "label": "First name:",
			                "name": "first_name"
			            }, {
			                "label": "Last name:",
			                "name": "last_name"
			            }, {
			                "label": "Position:",
			                "name": "position"
			            }, {
			                "label": "Office:",
			                "name": "office"
			            }, {
			                "label": "Extension:",
			                "name": "extn"
			            }, {
			                "label": "Start date:",
			                "name": "start_date",
			                "type": "datetime"
			            }, {
			                "label": "Salary:",
			                "name": "salary"
			            }
			        ]
			    } );
			    
			 // Edit record
			    $('#customerlisttable').on('click', 'a.editor_edit', function (e) {
			        e.preventDefault();
			 
			        editor.edit( $(this).closest('tr'), {
			            title: 'Edit record',
			            buttons: 'Update'
			        } );
			    } );
			    // Delete a record
			    $('#example').on('click', 'a.editor_remove', function (e) {
			        e.preventDefault();
			 
			        editor.remove( $(this).closest('tr'), {
			            title: 'Delete record',
			            message: 'Are you sure you wish to remove this record?',
			            buttons: 'Delete'
			        } );
			    } );
			 
			</script>
			<!-- <script type="text/javascript">

						var peopleList = new Array();
						
						<c:forEach var="tempCustomer" items="${customers}">
						    var people = new Object();
						    people.name = '${tempCustomer.firstName}';	    
						    peopleList.push(people);
						    alert(people.name);
						</c:forEach>
						
						if(peopleList.length > 0){
						    alert(people.name);
						}
						
					</script> -->
					
					<input type="file" accept="image/*" onchange="loadFile(event)">
<img id="output"/>
<script>
  var loadFile = function(event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function() {
      URL.revokeObjectURL(output.src) // free memory
    }
  };
</script>
		</div>

	</div>


</body>

</html>
