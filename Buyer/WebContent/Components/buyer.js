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
	var status = validateBuyerForm(); 
	if (status != true) 
 	{ 
 		$("#alertError").text(status); 
 		$("#alertError").show(); 
 		return; 
	} 
	// If valid------------------------
 		var type = ($("#hidBuyerIDSave").val() == "") ? "POST" : "PUT"; 
 		 $('input[name="buyerGender"]:checked').val(), 

 		$.ajax( 
 	{ 
 		url : "BuyersAPI", 
	 	type : type, 
 		data : $("#formBuyer").serialize(), 
 		dataType : "text", 
 		complete : function(response, status) 
 	{ 
 	onBuyerSaveComplete(response.responseText, status); 
 	} 
 	});
});

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 	$("#hidBuyerIDSave").val($(this).data("buyerid")); 
 	$("#buyerFname").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#buyerLname").val($(this).closest("tr").find('td:eq(2)').text()); 
	$("INPUT[name=buyerGender]").val([$(this).closest("tr").find('td:eq(3)').text()]);
 	$("#buyerAddress").val($(this).closest("tr").find('td:eq(4)').text()); 
	$("#buyerPhone").val($(this).closest("tr").find('td:eq(5)').text()); 
	$("#buyerNic").val($(this).closest("tr").find('td:eq(6)').text()); 
	$("#buyerBirthday").val($(this).closest("tr").find('td:eq(7)').text()); 
	$("#buyerEmail").val($(this).closest("tr").find('td:eq(8)').text()); 
	$("#buyerPassword").val($(this).closest("tr").find('td:eq(9)').text()); 


});

// DELETE=====================================================
$(document).on("click", ".btnRemove", function(event)
{ 
 $.ajax( 
 { 
 url : "BuyersAPI", 
 type : "DELETE", 
 data : "buyerID=" + $(this).data("buyerid"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onBuyerDeleteComplete(response.responseText, status); 
 } 
 }); 
});


// CLIENT-MODEL================================================================

function validateBuyerForm()
{
 //Validations
 if($("#buyerFname").val().trim() ==""){
 	return "Insert First Name."; 
 
 }
 if($("#buyerLname").val().trim()==""){
 	return "Insert Last Name.";
 }
if ($('input[name="buyerGender"]:checked').length === 0)
{
return "Select gender.";
}

if( $("#buyerAddress").val().trim()==""){
	return "Insert Address";
}
if($("#buyerPhone").val().trim()==""){
	return "Insert Phone Number";
}

 if($("#buyerNic").val().trim()==""){
    return "Insert Nic.";
 }
if ($("#buyerBirthday").val() == "0")
{
return "Select year.";
}
 if($("#buyerEmail").val().trim()==""){
    return "Insert Email";
 }
 if($("#buyerPassword").val().trim()==""){
 	return "Insert Password";
 }  
 return true;
}



function onBuyerSaveComplete(response, status)
{

if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divBuyersGrid").html(resultSet.data);
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
$("#hidBuyerIDSave").val("");
 $("#formBuyer")[0].reset(); 
	
}


// function Researcher Delete====================

function onBuyerDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divBuyersGrid").html(resultSet.data); 
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


