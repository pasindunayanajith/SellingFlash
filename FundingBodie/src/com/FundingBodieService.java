package com;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

//For JSON
import com.google.gson.*;



@Path("/FundingBodies")

public class FundingBodieService {
	 FundingBodie fbObj= new FundingBodie();
   
//All readFundingBodies Path	 
	 @GET
	 @Path("/")
	 @Produces(MediaType.TEXT_HTML)
	 public String readFundingBodies()
	  {
	 	 return fbObj.readFundingBodies(); 
	  }
	 
//All insertFundingBodies Path
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertFundingBodie(@FormParam("fbName") String fbName,
	 @FormParam("fbAddress") String fbAddress,
	 @FormParam("fbPhone") String fbPhone,
	 @FormParam("fbEmail") String fbEmail,
	 @FormParam("fbPassword") String fbPassword,
	 @FormParam("fbDescription") String fbDescription)
      
	{
	 String output = fbObj.insertFundingBodie(fbName, fbAddress, fbPhone, fbEmail,fbPassword,fbDescription);
	return output;
	}

//All UpdateFundingBodies Path
@PUT
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public String updateFundingBodie(String fbData)
{
//Convert the input string to a JSON object
 JsonObject fbObject = new JsonParser().parse(fbData).getAsJsonObject();//Read the values from the JSON object
 String fbID = fbObject.get("fbID").getAsString();
 String fbName = fbObject.get("fbName").getAsString();
 String fbAddress = fbObject.get("fbAddress").getAsString();
 String fbEmail = fbObject.get("fbEmail").getAsString();
 String fbPhone = fbObject.get("fbPhone").getAsString();
 String fbPassword = fbObject.get("fbPassword").getAsString();
 String fbDescription = fbObject.get("fbDescription").getAsString();

 String output = fbObj.updateFundingBodie(fbID, fbName, fbAddress,fbEmail ,fbPhone, fbPassword, fbDescription) ;
return output;
}


//View Profile Id Pass Path
@POST
@Path("/ViewProfileFundingBodies")
@Produces(MediaType.TEXT_HTML)
public String  ViewLabDetails(@FormParam("fbID") int fbID) {
	return fbObj.ViewProileFundingBodie(fbID);
}

//View FindingbodyServices  For Users Path
@GET
@Path("/ViewForUsers")
@Produces(MediaType.TEXT_HTML)
public String readFundingBodiesForUsers()
 {
	 return fbObj.readFundingBodiesForUsers(); 
 }

//Delete fundingbodie PATH
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteFundingBodie(String fundingbodieData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(fundingbodieData, "", Parser.xmlParser());

		//Read the value from the element <productID>
		 String fbID = doc.select("fbID").text();
		 String output = fbObj.deleteFundingBodie(fbID);
		return output;
		}

}
