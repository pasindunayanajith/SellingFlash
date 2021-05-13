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
	var status = validateFundingbodieForm(); 
	if (status != true) 
 	{ 
 		$("#alertError").text(status); 
 		$("#alertError").show(); 
 		return; 
	} 
	
	// If valid------------------------
 		var type = ($("#hidFundingbodieIDSave").val() == "") ? "POST" : "PUT"; 

 		$.ajax( 
 	{ 
 		url : "FundingbodiesAPI", 
	 	type : type, 
 		
	
	
	data :  $("#formFundingbodie").serialize(),


 
 		dataType : "text", 
 		complete : function(response, status) 
 	{ 
 	onFundingbodieSaveComplete(response.responseText, status); 
 	} 
 	});
});

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 	$("#hidFundingbodieIDSave").val($(this).data("fbid")); 
 	$("#fbName").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#fbAddress").val($(this).closest("tr").find('td:eq(2)').text()); 
 	$("#fbPhone").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#fbEmail").val($(this).closest("tr").find('td:eq(4)').text()); 
	$("#fbPassword").val($(this).closest("tr").find('td:eq(5)').text()); 
	$("#fbDescription").val($(this).closest("tr").find('td:eq(6)').text()); 
	

});

// DELETE=====================================================
$(document).on("click", ".btnRemove", function(event)
{ 
 $.ajax( 
 { 
 url : "FundingbodiesAPI", 
 type : "DELETE", 
 data : "fbID=" + $(this).data("fbid"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onFundingbodieDeleteComplete(response.responseText, status); 
 } 
 }); 
});


// CLIENT-MODEL================================================================

function validateFundingbodieForm()
{
 //Validations
 if($("#fbName").val().trim() ==""){
 	return "Insert Company Name."; 
 
 }
if( $("#fbAddress").val().trim()==""){
	return "Insert Address";
}
if($("#fbPhone").val().trim()==""){
	return "Insert Phone Number";
}

 if($("#fbEmail").val().trim()==""){
    return "Insert Email.";
 }
 if($("#fbPassword").val().trim()==""){
    return "Insert Password";
 }
 if($("#fbDescription").val().trim()==""){
    return "Insert Description";
 }
 
 
 return true;
}



function onFundingbodieSaveComplete(response, status)
{

if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divFundingbodiesGrid").html(resultSet.data);
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
$("#hidFundingbodieIDSave").val("");
 $("#formFundingbodie")[0].reset(); 
	
}


// function Researcher Delete====================

function onFundingbodieDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divFundingbodiesGrid").html(resultSet.data); 
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


