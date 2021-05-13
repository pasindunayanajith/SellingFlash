/**
 * 
 */
$(document).ready(function()
{ 
	if ($("#alertSuccess").text().trim() == "") 
 	{ 
 	$("#alertSuccess").hide(); 
 	} 
 	$("#alertError").hide(); 
});

 // SAVE ============================================
$(document).on("click", "#btnSave", function(event) 
{ 
	// Clear alerts---------------------
 	$("#alertSuccess").text(""); 
 	$("#alertSuccess").hide(); 
 	$("#alertError").text(""); 
 	$("#alertError").hide(); 
	// Form validation-------------------
	var status = validatePaymentForm(); 
	if (status != true) 
 	{ 
 		$("#alertError").text(status); 
 		$("#alertError").show(); 
 		return; 
	} 
	// If valid------------------------
 		var type = ($("#hidPaymentIDSave").val() == "") ? "POST" : "PUT"; 
 		 $('input[name="paymentType"]:checked').val(), 

 		$.ajax( 
 	{ 
 		url : "PaymentsAPI", 
	 	type : type, 
 		data : $("#formPayment").serialize(), 
 		dataType : "text", 
 		complete : function(response, status) 
 	{ 
 	onPaymentSaveComplete(response.responseText, status); 
 	} 
 	});
});

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 	$("#hidPaymentIDSave").val($(this).data("paymentid")); 
 	$("#paymentPostaladdress").val($(this).closest("tr").find('td:eq(4)').text()); 
	$("#paymentPostalcode").val($(this).closest("tr").find('td:eq(5)').text()); 

});

// DELETE=====================================================
$(document).on("click", ".btnRemove", function(event)
{ 
 $.ajax( 
 { 
 url : "PaymentsAPI", 
 type : "DELETE", 
 data : "paymantID=" + $(this).data("paymentid"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onPaymentDeleteComplete(response.responseText, status); 
 } 
 }); 
});


// CLIENT-MODEL================================================================

function validatePaymentForm()
{
 //Validations
 if($("#paymentPostaladdress").val().trim() ==""){
 	return "Insert Payment Address."; 
 
 }



 return true;
}



function onPaymentSaveComplete(response, status)
{

if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divPaymentsGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while saving.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while saving..");
 $("#alertError").show();
 } 
$("#hidPaymentIDSave").val("");
 $("#formPayment")[0].reset(); 
	
}


// function Researcher Delete====================

function onPaymentDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divPaymentsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}


