<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendors</title>
<c:url value="/resources/js/vendors.js" var="myUrl" />
<script type="text/javascript" src="${myUrl}" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<SCRIPT language="javascript">
<!--
	function addRow(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name = "chkbox[]";
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		cell2.innerHTML = rowCount + 1;

		var cell3 = row.insertCell(2);
		var element2 = document.createElement("input");
		element2.type = "text";
		var length = (table.rows.length) - 1;
		element2.name = "operationParameterses[" + length + "].name";
		cell3.appendChild(element2);

	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for (var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
		} catch (e) {
			alert(e);
		}
	}

	function addFiles() {
		$('#fileTable tbody').append(
				'<tr><td>' + '	<input type="file" class="mb-3" name="file"/>'
						+ '</td></tr>');
	}
</SCRIPT>

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<c:url value="/submitvendor" var="submitvendor" />
	<c:url value="/ajaxdata" var="sendjson" />
	<c:url value="/vendors/loadmore" var="viewmore" />
	<c:url value="/vendors/showAllvendors" var="showAllvendors" />
	<div class="container">
		<form:form action="${submitvendor}" modelAttribute="theVendor"
			method="post" validate="true" enctype="multipart/form-data">
			<div class="row form-group"></div>
			<div class="row form-group">
				<label class="control-label col-md-1" for="vendorname">Vendor
					Name</label>
				<div class="col-sm-5">
					<form:input path="vendorname" type="text" class="form-control"
						placeholder="First and last name" />
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-md-1" for="product">Product</label>
				<div class="col-sm-5">
					<form:input path="vendorproduct" type="text" class="form-control"
						placeholder="Product" required="true" />
				</div>
			</div>
			<INPUT id="addFile" type="button" class="btn btn-primary mb-3"
				value="Add File" onclick="addFiles();" />
			<TABLE id="fileTable" class="table table-bordered table-striped"
				width="350px" border="1">
				<TR>
					<TD><input type="file" class="mb-3" name="upload" /></TD>
				</TR>
			</TABLE>
			<fieldset>
				<button class="btn btn-primary" type=submit>Save Vendor</button>
			</fieldset>
		</form:form>
		<span>
			<p>
				<label>Total Customers: ${totalcusts} </label>
			</p>
		</span>

		<table id="customerlisttable"
			class="table table-bordered table-striped display">
			<thead class="thead-dark">
				<tr>
					<th>Vendor Id</th>
					<th>Vendor Name</th>
					<th>Vendor Product</th>
				</tr>
			</thead>
		</table>
		<button id="sendBtn" class="btn btn-primary"
			onclick="sendAjax('${sendjson}');" type="button">Send Json</button>
		<div class="row">
			<label> Showing </label><input type="text" id="disprec" value="4"></label><label>
				records</label>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(
			function() {

				$.ajax({
					"type" : 'POST',
					"url" : '${showAllvendors}',
					"data" : JSON.stringify({
						"value" : '4'
					}),
					contentType : "application/json",
					dataType : "json",
					"success" : function(ajaxresponse) {
						var response = ajaxresponse;

						$('#customerlisttable').DataTable({
							"paging" : false,
							"info" : false,
							"searching" : false,
							"data" : response,
							"columns" : [ {
								"data" : "Id"
							}, {
								"data" : "vendorname"
							}, {
								"data" : "vendorproduct"
							}, ]
						});
					}
				});

				$(window).scroll(
						function() {
							if ($(window).scrollTop() >= $(document).height()
									- $(window).height()) {
								loadmorerows('${viewmore}');
							}

						});
				/* var responsedata ='${dtablejson}';
				var jsonData = JSON.parse(responsedata);
				$('#customerlisttable').DataTable({
					"paging": false,
					"info": false,
					"searching" : false,
				    "data": jsonData,
				    "columns": [
				      { "data": "Id" },
				      { "data": "vendorname" },
				      { "data": "vendorproduct" },
				    ]
				}); */
			});

	/* $(document).ready(function() {
		var data ='${dtablejson}';
		alert('data: '+data);
		  var table = $('#customerlisttable').DataTable({
		 
		    "iDisplayLength": 10,
		    "aLengthMenu": [
		      [5, 10, 20, 25, 50, -1],
		      [5, 10, 20, 25, 50, "All"]
		    ],
		    "aaSorting": [
		      [0, 'asc']
		    ],
		    "sAjaxSource": 'https://raw.githubusercontent.com/kshkrao3/JsonFileSample/master/EmployeeTables.json',
		        "columns": [
		            { "data": "empId"},
		            { "data": "firstName"},
		            { "data": "lastName"}
		        ]
		  });
		}); */
	/* var l = $('#customerlisttable tr').length;
	$('#sendBtn').click(function() {
		$.ajax({
			   
		    type: "GET",
		    url: ${sendjson},       
		    data: "data=reqdata"  ,               
		    dataType: "json",
		    success: function(json){
		       console.log(json);
		    }
		}).done(function(data){
			
		}).fail(function(jqXHR, textStatus){
			alert(textStatus);
		});	
	}); */
</script>
</html>