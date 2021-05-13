package com;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Path("/Researchers")

public class ResearcherService {
	Researcher researcherObj= new Researcher();
//Get path All Researchers  
	@GET
	 @Path("/")
	 @Produces(MediaType.TEXT_HTML)
	 public String readResearcherService()
	  {
	 	 return researcherObj.readReseacher();
	  }
//Post path All Researchers	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String insertResearcher(@FormParam("researcherFname") String researcherFname,
	 @FormParam("researcherLname") String researcherLname,
	 @FormParam("researcherGender") String researcherGender,
	 @FormParam("researcherNic") String researcherNic,
	 @FormParam("researcherPhone") String researcherPhone,
	 @FormParam("researcherBirthday") String researcherBirthday,
	 @FormParam("researcherEmail") String researcherEmail,
	 @FormParam("researcherPassword") String researcherPassword,
	 @FormParam("researchDetails") String researchDetails,
	 @FormParam("accountnumber") String accountnumber,
	 @FormParam("bankname") String bankname)



	{
	 String output = researcherObj.insertResearcher( researcherFname,  researcherLname,  researcherGender,  researcherNic, researcherPhone,researcherBirthday,  researcherEmail,  researcherPassword,researchDetails,accountnumber,bankname);
	return output;
	}

//Put path All Researchers
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String updateResearcher(String researcherData) {
	
		//Convert the input string to a JSON object
		 JsonObject researcherObject = new JsonParser().parse(researcherData).getAsJsonObject();//Read the values from the JSON object			 
		 String researcherID  = researcherObject.get("researcherID").getAsString();
		 String researcherFname = researcherObject.get("researcherFname").getAsString();
		 String researcherLname = researcherObject.get("researcherLname").getAsString();
		 String researcherGender = researcherObject.get("researcherGender").getAsString();
		 String researcherNic  = researcherObject.get("researcherNic").getAsString();
		 String researcherPhone = researcherObject.get("researcherPhone").getAsString();
		 String researcherBirthday = researcherObject.get("researcherBirthday").getAsString();
		 String researcherEmail  = researcherObject.get("researcherEmail").getAsString();
		 String researcherPassword = researcherObject.get("researcherPassword").getAsString();
		 String researchDetails = researcherObject.get("researchDetails").getAsString();
		 String accountnumber=researcherObject.get("accountnumber").getAsString();
		 String bankname=researcherObject.get("bankname").getAsString();
		String output = researcherObj.updateResearcher( researcherID, researcherFname,  researcherLname,  researcherGender,researcherNic ,researcherPhone,researcherBirthday,researcherEmail , researcherPassword,researchDetails,accountnumber,bankname) ;
		return output;
	}
	
//View Profile Researchers path
	@POST
	@Path("/ViewProfileReasearchers")
	@Produces(MediaType.TEXT_HTML)
	public String  ViewResearcherDetails(@FormParam("researcherID") int researcherId) {
		return researcherObj.ViewProileReasearcher(researcherId);
	}

	//View All Researchers for Users (Without Buyers)
	@GET
	 @Path("/ViewForUsers")
	 @Produces(MediaType.TEXT_HTML)
	 public String readReasearchersForUsers()
	  {
	 	 return researcherObj.readReasearchersForUsers();
	  }
	
//Delete Path All
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteReasearcher(String researcherData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(researcherData, "", Parser.xmlParser());

	//Read the value from the element <researcherID>
	 String researcherID = doc.select("researcherID").text();
	 String output = researcherObj.deleteResearcher(researcherID);
	return output;
	}

}
