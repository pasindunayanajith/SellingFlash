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
	var status = validateResearcherForm(); 
	if (status != true) 
 	{ 
 		$("#alertError").text(status); 
 		$("#alertError").show(); 
 		return; 
	} 
	// If valid------------------------
 		var type = ($("#hidResearcherIDSave").val() == "") ? "POST" : "PUT"; 
 		 $('input[name="researcherGender"]:checked').val(), 

 		$.ajax( 
 	{ 
 		url : "ResearchersAPI", 
	 	type : type, 
 		data : $("#formResearcher").serialize(), 
 		dataType : "text", 
 		complete : function(response, status) 
 	{ 
 	onResearcherSaveComplete(response.responseText, status); 
 	} 
 	});
});

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 	$("#hidResearcherIDSave").val($(this).data("researcherid")); 
 	$("#researcherFname").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#researcherLname").val($(this).closest("tr").find('td:eq(2)').text()); 
	$("INPUT[name=researcherGender]").val([$(this).closest("tr").find('td:eq(3)').text()]);
 	$("#researcherNic").val($(this).closest("tr").find('td:eq(4)').text()); 
	$("#researcherPhone").val($(this).closest("tr").find('td:eq(5)').text()); 
	$("#researcherBirthday").val($(this).closest("tr").find('td:eq(6)').text()); 
	$("#researcherEmail").val($(this).closest("tr").find('td:eq(7)').text()); 
	$("#researcherPassword").val($(this).closest("tr").find('td:eq(8)').text()); 
	$("#researchDetails").val($(this).closest("tr").find('td:eq(9)').text()); 
	$("#accountnumber").val($(this).closest("tr").find('td:eq(10)').text()); 
 	$("#bankname").val($(this).closest("tr").find('td:eq(11)').text()); 

});

// DELETE=====================================================
$(document).on("click", ".btnRemove", function(event)
{ 
 $.ajax( 
 { 
 url : "ResearchersAPI", 
 type : "DELETE", 
 data : "researcherID=" + $(this).data("researcherid"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onResearcherDeleteComplete(response.responseText, status); 
 } 
 }); 
});


// CLIENT-MODEL================================================================

function validateResearcherForm()
{
 //Validations
 if($("#researcherFname").val().trim() ==""){
 	return "Insert First Name."; 
 
 }
 if($("#researcherLname").val().trim()==""){
 	return "Insert Last Name.";
 }
if ($('input[name="researcherGender"]:checked').length === 0)
{
return "Select gender.";
}
if( $("#researcherNic").val().trim()==""){
	return "Insert Nic";
}
if($("#researcherPhone").val().trim()==""){
	return "Insert Phone Number";
}
if ($("#researcherBirthday").val() == "0")
{
return "Select year.";
}
if($("#researcherEmail").val().trim()==""){
    return "Insert Email.";
 }
if($("#researcherPassword").val().trim()==""){
 	return "Insert Password";
 }
 if($("#accountnumber").val().trim()==""){
    return "Insert Account Number";
 }
 if($("#bankname").val().trim()==""){
    return "Insert Bank Name";
 }
 if($("#researchDetails").val().trim()==""){
 	return "Insert Research Details";
 }
 
 
 return true;
}



function onResearcherSaveComplete(response, status)
{

if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divResearchersGrid").html(resultSet.data);
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
$("#hidResearcherIDSave").val("");
 $("#formResearcher")[0].reset(); 
	
}


// function Researcher Delete====================

function onResearcherDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divResearchersGrid").html(resultSet.data); 
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


