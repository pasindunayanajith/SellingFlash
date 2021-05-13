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
	var status = validateProductForm(); 
	if (status != true) 
 	{ 
 		$("#alertError").text(status); 
 		$("#alertError").show(); 
 		return; 
	} 
	// If valid------------------------
 		var type = ($("#hidProductIDSave").val() == "") ? "POST" : "PUT"; 
 		 $('input[name="availability"]:checked').val(), 

 		$.ajax( 
 	{ 
 		url : "ProductsAPI", 
	 	type : type, 
 		data : $("#formProduct").serialize(), 
 		dataType : "text", 
 		complete : function(response, status) 
 	{ 
 	onProductSaveComplete(response.responseText, status); 
 	} 
 	});
});

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 	$("#hidProductIDSave").val($(this).data("productid")); 
 	$("#productName").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#productItemcode").val($(this).closest("tr").find('td:eq(2)').text()); 
 	$("#productPrice").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#productStock").val($(this).closest("tr").find('td:eq(4)').text()); 
	$("#productDescription").val($(this).closest("tr").find('td:eq(5)').text()); 
	$("#researcherID").val($(this).closest("tr").find('td:eq(6)').text()); 
	$("#delivertime").val($(this).closest("tr").find('td:eq(9)').text()); 
	$("INPUT[name=availability]").val([$(this).closest("tr").find('td:eq(10)').text()]);



});

// DELETE=====================================================
$(document).on("click", ".btnRemove", function(event)
{ 
 $.ajax( 
 { 
 url : "ProductsAPI", 
 type : "DELETE", 
 data : "productID=" + $(this).data("productid"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onProductDeleteComplete(response.responseText, status); 
 } 
 }); 
});


// CLIENT-MODEL================================================================

function validateProductForm()
{
 //Validations
 if($("#productName").val().trim() ==""){
 	return "Insert Product Name"; 
 
 }
 if($("#productItemcode").val().trim() ==""){

 	return "Insert Product Item Code"; 
 
 }

// is numerical value
	var tmpPrice = $("#productPrice").val().trim(); 
	if (!$.isNumeric(tmpPrice)) 
 	{ 
 		return "Insert a numerical value for Item Price."; 
 	} 
	// convert to decimal price
 	$("#productPrice").val(parseFloat(tmpPrice).toFixed(2)); 

if($("#productStock").val().trim()==""){
	return "Insert Product Stock";
}

 if($("#productDescription").val().trim()==""){
    return "Insert Descripition.";
 }


 if($("#researcherID").val().trim()==""){
    return "Insert researcher id";

 } 
if($("#delivertime").val().trim()==""){
    return "Insert Deliver time";
 }

 
 return true;
}



function onProductSaveComplete(response, status)
{

if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divProductsGrid").html(resultSet.data);
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
$("#hidProductIDSave").val("");
 $("#formProduct")[0].reset(); 
	
}


// function Researcher Delete====================

function onProductDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divProductsGrid").html(resultSet.data); 
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


