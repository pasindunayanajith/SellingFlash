package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

//For JSON
import com.google.gson.*;

@Path("/Buyers")

public class BuyerService {

	Buyer buyerObj= new Buyer();
//Read All buyers path	 
		 @GET
		 @Path("/")
		 @Produces(MediaType.TEXT_HTML)
		 public String readBuyerService()
		  {
		 	 return buyerObj.readBuyer();
		  }
		 
//Insert All buyers Path
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String insertBuyer(@FormParam("buyerFname") String buyerFname,
		 @FormParam("buyerLname") String buyerLname,
		 @FormParam("buyerGender") String buyerGender,
		 @FormParam("buyerAddress") String buyerAddress,
		 @FormParam("buyerPhone") String buyerPhone,
		 @FormParam("buyerNic") String buyerNic,
		 @FormParam("buyerBirthday") String buyerBirthday,
		 @FormParam("buyerEmail") String buyerEmail,
		 @FormParam("buyerPassword") String buyerPassword) 
		

	{
		 String output = buyerObj.insertBuyer( buyerFname,  buyerLname,  buyerGender,  buyerAddress, buyerPhone,  buyerNic, buyerBirthday  ,buyerEmail,  buyerPassword);
		 return output;
	}

//Update All Buyers path
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		
		
		public String updateBuyer(String buyerData) {
		
			//Convert the input string to a JSON object
			 JsonObject buyerObject = new JsonParser().parse(buyerData).getAsJsonObject();//Read the values from the JSON object			 
			 String buyerID  = buyerObject.get("buyerID").getAsString();
			 String buyerFname = buyerObject.get("buyerFname").getAsString();
			 String buyerLname = buyerObject.get("buyerLname").getAsString();
			 String buyerGender = buyerObject.get("buyerGender").getAsString();
			 String buyerAddress = buyerObject.get("buyerAddress").getAsString();
			 String buyerPhone = buyerObject.get("buyerPhone").getAsString();
			 String buyerNic = buyerObject.get("buyerNic").getAsString();
			 String buyerBirthday=buyerObject.get("buyerBirthday").getAsString();
			 String buyerEmail = buyerObject.get("buyerEmail").getAsString();
			 String buyerPassword = buyerObject.get("buyerPassword").getAsString();

			 String output = buyerObj.updateBuyer( buyerID, buyerFname,  buyerLname,  buyerGender,  buyerAddress, buyerPhone, buyerNic ,buyerBirthday,buyerEmail  ,buyerPassword) ;
			 return output;
		}
	
//Delete All Buyers Path
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteBuyer(String buyerData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(buyerData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		 String buyerID  = doc.select("buyerID").text();
		 String output = buyerObj.deleteBuyer(buyerID);
		 return output;
		}

//View Buyer Profile Path
		@POST
		@Path("/viewProfileBuyers")
		@Produces(MediaType.TEXT_HTML)
		public String  ViewBuyerDetails(@FormParam("buyerID") int buyerId) {
		return buyerObj.viewProfileBuyers(buyerId);
		}		
}
