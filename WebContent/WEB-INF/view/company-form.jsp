<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	
	function addFiles(){
		$('#fileTable tbody').append(
					'<tr><td>'+
					'	<input type="file" class="mb-3" name="upload"/>'+
					'</td></tr>');
	}
</SCRIPT>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<c:url value="/company/proceedCompany" var="proceedurl"></c:url>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	
		<form:form action="${proceedurl}" modelAttribute="users" method="post" >
			
			<c:if test="${not empty successmsg}">
				<p style="font-size: 20; color: #228B22; text-align: center;">${successmsg}</p>
			</c:if>
			<div class="row form-group">
				<label class="control-label col-md-1" for="name">Full Name</label>
				<div class="col-sm-5">
					<form:input path="name" type="text" class="form-control" placeholder="First and last name" />
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-md-1" for="dob">DOB</label>
				<div class="col-sm-5">
				<form:input path="dob" type="date"  class="form-control" required="true" />
				</div>
			</div>
			
			<div class="row form-group">
				<label class="control-label col-md-1" for="phone">Phone</label>
				<div class="col-md-5">
				<form:input path="phone" type="text" class="form-control" required="true" placeholder="Phone"/>
				</div>
			</div>

			<INPUT type="button" class="btn btn-primary mb-3" value="Add Row" onclick="addRow('dataTable')" />
			<INPUT type="button" class="btn btn-primary mb-3" value="Delete Row"	onclick="deleteRow('dataTable')" />
			<TABLE id="dataTable" class="table table-bordered table-striped" width="150px" border="1">
				<TR>
					<TD><INPUT type="checkbox" name="chk" /></TD>
					<TD>1</TD>
					<TD><INPUT type='text' name="operationParameterses[0].name" />
					</TD>
				</TR>
			</TABLE>
			</li>
			<INPUT id="addFile" type="button" class="btn btn-primary mb-3" value="Add File" onclick="addFiles();" />
			<TABLE id="fileTable" class="table table-bordered table-striped" width="350px" border="1">
				<TR>
					<TD>
						<input type="file" class="mb-3" name="upload"/>
					</TD>
				</TR>
			</TABLE>
			
                
                Dynamically data entered below:
                <ol>
				<%-- <c:forEach items="${users.operationParameterses}" var="value">
					//<li><c:out value="${value.name}" /></li>
				</c:forEach> --%>
			</ol>

			<fieldset>
				<button class="btn btn-primary" type=submit>Save User Details</button>
			</fieldset>
		</form:form>
	</div>



</body>
</html>