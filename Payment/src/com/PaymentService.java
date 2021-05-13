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
@Path("/Payments")

public class PaymentService {

	Payment paymentObj= new Payment();
	
	//Read All Payments Path(View  Bought Product Payment Details for Admin)
		 @GET
		 @Path("/")
		 @Produces(MediaType.TEXT_HTML)
		 public String readPaymentService()
		  {
		 	 return paymentObj.readPayment();
		  }
	
	//Insert Payment Path
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String insertPayment( @FormParam("paymentType") String paymentType,
		 @FormParam("paymentAmount") String paymentAmount,
		 @FormParam("paymentDate") String paymentDate,
		 @FormParam("paymentPostaladdress") String paymentPostaladdress,
		 @FormParam("paymentPostalcode") String paymentPostalcode,
		 @FormParam("productID") String productID,
		 @FormParam("buyerID") String buyerID)


		{
		 String output = paymentObj.insertPayment( paymentType,  paymentAmount,paymentDate ,paymentPostaladdress,paymentPostalcode,productID,buyerID);
		return output;
		}


//Update Payment path(Rechecking Biling Information)
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
				
		public String updatePayment(String paymentData) {
		
			//Convert the input string to a JSON object
			 JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();//Read the values from the JSON object			 
			 String paymantID  = paymentObject.get("paymantID").getAsString();
			 String paymentPostaladdress = paymentObject.get("paymentPostaladdress").getAsString();
			 String paymentPostalcode = paymentObject.get("paymentPostalcode").getAsString();
			
			String output = paymentObj.updatePayment(paymantID,paymentPostaladdress,paymentPostalcode);
			return output;
		}
		

//Delete Payment PATH
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deletePayment(String paymentData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());

		//Read the value from the element <productID>
		 String paymentID = doc.select("paymentID").text();
		 String output = paymentObj.deletePayment(paymentID);
		return output;
		}

  //View Own Payment For Buyers path
		@POST
		@Path("/ViewOwnPayments")
		@Produces(MediaType.TEXT_HTML)
		public String  ViewPaymentDetails(@FormParam("buyerID") int buyerId) {
			return paymentObj.ViewPaymentProducts(buyerId);
			
		}
		
 //View  Ordered Product Payment Details For Researchers path
		@POST
		@Path("/ViewBoughtPayments")
		@Produces(MediaType.TEXT_HTML)
		public String  ViewBoughtPaymentsDetails(@FormParam("researcherID") int researchrID) {
			return paymentObj.ViewBoughtPayments(researchrID);
			
		}	
		
}
