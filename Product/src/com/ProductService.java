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

@Path("/Products")

public class ProductService {

	Product productObj= new Product();
//read all product(With Manage For Admin) path
		@GET
		 @Path("/")
		 @Produces(MediaType.TEXT_HTML)
		 public String readProductService()
		  {
		 	 return productObj.readProduct();
		  }

//read all product(View For Users) path
		@GET
		 @Path("/productViewForUsers")
		 @Produces(MediaType.TEXT_HTML)
		 public String productViewForUsers()
		  {
		 	 return productObj.productViewForUsers();
		  }
		
	    
//Insert All Product Path
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String insertProduct(@FormParam("productName") String productName,
		 @FormParam("productItemcode") String productItemcode,
		 @FormParam("productPrice") String productPrice,
		 @FormParam("productStock") String productStock,
		 @FormParam("productDescription") String productDescription,
		 @FormParam("researcherID") String researchrID,
		 @FormParam("delivertime") String delivertime,
		 @FormParam("availability") String availability

		)
		

		{
		 String output = productObj.insertProduct( productName,  productItemcode,  productPrice,  productStock, productDescription,researchrID,delivertime,availability);
		return output;
		}


//Update All  Product Path(Admin Update)
		@PUT
		@Path("")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
				
		public String updateProduct(String productData) {
		
			//Convert the input string to a JSON object
			 JsonObject productObject = new JsonParser().parse(productData).getAsJsonObject();//Read the values from the JSON object			 
			 String productID  = productObject.get("productID").getAsString();
			 String productName = productObject.get("productName").getAsString();
			 String productPrice = productObject.get("productPrice").getAsString();
			 String productStock = productObject.get("productStock").getAsString();
			 String producdtDescription = productObject.get("productDescription").getAsString();
             String embledCode1=productObject.get("embledCode1").getAsString();
             String embledCode2=productObject.get("embledCode2").getAsString();
             String delivertime=productObject.get("delivertime").getAsString();
             String availability=productObject.get("availability").getAsString();
             String approval=productObject.get("approval").getAsString();

			String output = productObj.updateProduct(productID, productName,  productPrice,  productStock,producdtDescription,embledCode1,embledCode2,delivertime,availability,approval);
			return output;
		}

//Update All  Product Path(Researcher Update)
		@PUT
		@Path("/updateProductReserchers")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
				
		public String updateProductResercher(String productData) {
		
			//Convert the input string to a JSON object
			 JsonObject productObject = new JsonParser().parse(productData).getAsJsonObject();//Read the values from the JSON object			 
			 String productID  = productObject.get("productID").getAsString();
			 String productName = productObject.get("productName").getAsString();
			 String productPrice = productObject.get("productPrice").getAsString();
			 String productStock = productObject.get("productStock").getAsString();
			 String producdtDescription = productObject.get("productDescription").getAsString();
             String delivertime=productObject.get("delivertime").getAsString();
             String availability=productObject.get("availability").getAsString();

			String output = productObj.updateProductResercher(productID, productName,  productPrice,  productStock,producdtDescription,delivertime,availability);
			return output;
		}

		
//View Added Own Product Path
		@POST
		@Path("/ViewOwnProducts")
		@Produces(MediaType.TEXT_HTML)
		public String  ViewLabDetails(@FormParam("researcherID") int researcherId) {
			return productObj.ViewOwnProducts(researcherId);
			
		}
		
//Delete Path All
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteProduct(String productData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(productData, "", Parser.xmlParser());

		//Read the value from the element <productID>
		 String productID = doc.select("productID").text();
		 String output = productObj.deleteProduct(productID);
		return output;
		}
		


}
