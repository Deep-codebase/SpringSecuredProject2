

function success() {
	alert('success');
}
function error() {
	alert('error');
}
function sendAjax(urljson) {
	var text = $('#vendorname').val();
	var name = $('#vendorproduct').val();
	$.ajax({
		"type" : 'POST',
		"url" : urljson,
		"data" : JSON.stringify({
			"text" : text,
			"name" : name
		}),
		"success" : success,
		"error" : error,
		contentType : "application/json",
		dataType : "json",
	});
}

function loadmorerows(urljson) {
	
	var start = $('#disprec').val();
	
	$.ajax({
		"type" : 'POST',
		"url" : urljson,
		"data" : JSON.stringify({
			"value" : start
		}),
		contentType : "application/json",
		dataType : "json",
		"success" : function(ajaxresponse){
			var response = ajaxresponse;
			var end = response.end;
			if(response.data ==''){
				/*alert('No more records to display');*/
			}else{
				$('#disprec').val(end);
				$("#customerlisttable").dataTable().fnAddData(response.data);
			}
		}		
	});
}