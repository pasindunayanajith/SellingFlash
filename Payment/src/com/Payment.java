package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Payment {
	//****************************************Create Connection*****************************************
	//A common method to connect to the DB
	public Connection connect()
	{
	 Connection con = null;

	 try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gbsystem?useTimezone=true&serverTimezone=UTC", "root", "");
	 //For testing
	 System.out.print("Successfully connected");
	 }
	 catch(Exception e)
	 {
	 e.printStackTrace();
	 }

	 return con;
	}

//************************************Insert Data**********(Insert payment details for buy prodcut individual)****************************************	
	public String insertPayment(String type,String amount ,String date,String postaladdress, String postalcode,String productid,String buyerid )
	 {																									//produtid and buyerid POST data(Forign key) 
	 
		String output = "";
	
	try
	 {
	 Connection con = connect();
	 
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 
	 // create a prepared statement
	 String query = " insert into payment(`paymantID`,`paymentType`,`paymentAmount`,`paymentDate`,`paymentPostaladdress`,`paymentPostalcode`,`productID`,`buyerID`)" + " values (?, ?, ?,?, ?,?,?,?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, type);
	 preparedStmt.setDouble(3, Double.parseDouble(amount));
	 preparedStmt.setString(4, date);

	 preparedStmt.setString(5, postaladdress);
	 preparedStmt.setString(6, postalcode);
    preparedStmt.setInt(7,Integer.parseInt(productid));
    preparedStmt.setInt(8,Integer.parseInt(buyerid));

	 

     // execute the statement
	 preparedStmt.execute();
	 //Connection close
	 con.close();
	 
	 String newPayments = readPayment();
	 output = "{\"status\":\"success\", \"data\": \"" + newPayments + "\"}"; 
	 
	}
	catch (Exception e)
	{
		output = "{\"status\":\"error\", \"data\": \"Error while inserting the payment.\"}"; 
	System.err.println(e.getMessage());
	}
	return output;
	}
	 
	 

	
	
	//************************************ Read Data********************************************************************************
	public String readPayment() {
		// TODO Auto-generated method stub
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		
		 // Prepare the html table to be displayed
		 output = "<table border='1'>"
		 		+ "<tr>"
				+"<th>Payment_ID</th>"
		 		+ "<th>Payment Type</th>"
		 		+ "<th>Amount</th>"
		 		+ "<th>Date</th>"
		 		+ "<th>Postal Address</th>"
		 		+"<th>Postal Code</th>"
		 		+"<th>Product Name</th>"
		 		+"<th>Product Itemcode</th>"
		 		+"<th>Product Stock</th>"
		 		+"<th>Product Description</th>"
		        +"<th>Buyer Email</th>"
		        +"<th>Buyer Contact Number</th>"
		 	    + "</tr>";

		 String query = "select p.paymantID,p.paymentType,p.paymentAmount,p.paymentDate,p.paymentPostaladdress,p.paymentPostalcode,pro.productName,pro.productItemcode,pro.productStock,pro.productDescription,b.buyerEmail,b.buyerPhone From(( product pro INNER JOIN payment p ON (p.productID=pro.productID) )INNER JOIN buyer b ON  (p.buyerID=b.buyerID)) ORDER BY p.paymantID ASC";
		 PreparedStatement stmt = con.prepareStatement(query);

		 ResultSet rs = stmt.executeQuery();
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String paymantID  = Integer.toString(rs.getInt("paymantID"));
		 String paymentType = rs.getString("paymentType");
		 String paymentAmount = rs.getString("paymentAmount");
		 Date paymentDate = rs.getDate("paymentDate");
		 String paymentPostaladdress = rs.getString("paymentPostaladdress");
		 String paymentPostalcode =rs.getString("paymentPostalcode");
		 String productName=rs.getString("productName");
		 String productItemcode=rs.getString("productItemcode");
		 String productStock=rs.getString("productStock");
		 String productDescription=rs.getString("productDescription");
		 String buyerEmail=rs.getString("buyerEmail");
		 String buyerPhone=rs.getString("buyerPhone");
		
		 // Add into the html table
		 output += "<tr><td>" + paymantID + "</td>";
		 output += "<td>" + paymentType + "</td>";
		 output += "<td>" + paymentAmount + "</td>";
		 output += "<td>" + paymentDate + "</td>";
		 output += "<td>" + paymentPostaladdress + "</td>";
		 output += "<td>" + paymentPostalcode + "</td>";
		 output += "<td>"+productName+"</td>";
		 output += "<td>"+productItemcode+"</td>";
		 output += "<td>"+productStock+"</td>";
		 output += "<td>"+productDescription+"</td>";
		 output += "<td>"+buyerEmail+"</td>";
		 output += "<td>"+buyerPhone+"</td>";
		
			
			// buttons
				output += "<td><input name='btnUpdate' "
				+ " type='button' value='Update' class='btnUpdate btn btn-primary' data-paymentid='" + paymantID  + "'></td>"
				+ "<td>"
				+ "<input name='btnRemove' "
				+ " type='button' value='Remove' class='btnRemove btn btn-danger' data-paymentid='" + paymantID  + "'>"
				+ "</td></tr>";
		 
		 
		 
		 
		 }
		 
		//Connection close
		 con.close();
		 
		 // Complete the html table
		 output += "</table>";
		 }
		 catch (Exception e)
		 {
		 output = "Error while reading the items.";
		 System.err.println(e.getMessage());
		 }
		 return output;
	}


	//************************************************Update Data(Re checking Billing information )***************************************************************
	public String updatePayment(String ID,String postaladdress, String postalcode)
	{
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for updating."; }
		 // create a prepared statement
		 String query = "UPDATE payment SET paymentPostaladdress=?,paymentPostalcode=? WHERE paymantID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 ;
		 preparedStmt.setString(1, postaladdress);
		 preparedStmt.setString(2, postalcode);
		 preparedStmt.setInt(3, Integer.parseInt(ID));
		   // execute the statement
		 preparedStmt.execute();
		 //Connection close
		 con.close();
		 
		 String newPayments = readPayment();
		 output = "{\"status\":\"success\", \"data\": \"" + newPayments + "\"}"; 
		 
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while updaing the payment.\"}"; 
		System.err.println(e.getMessage());
		}
		return output;
		}
		 
		 	
	
	//***************************************************Delete data****************************************************8
	public String deletePayment(String paymantID )
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from payment where paymantID =?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(paymantID));
	   // execute the statement
		 preparedStmt.execute();
		 //Connection close
		 con.close();
		 
		 String newPayments = readPayment();
		 output = "{\"status\":\"success\", \"data\": \"" + newPayments + "\"}"; 
		 
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the payment.\"}"; 
		System.err.println(e.getMessage());
		}
		return output;
		}
		 
		 

	//*********************************************View Own Payment For Buyers(Bougth Product)**********************************************
	public String ViewPaymentProducts(int buyerId) {
		// TODO Auto-generated method stub
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		
		 // Prepare the html table to be displayed
		 output = "<table border='1'>"
		 		+ "<tr>"
				+"<th>Payment_ID</th>"
		 		+ "<th>Payment Type</th>"
		 		+ "<th>Amount</th>"
		 		+ "<th>Date</th>"
		 		+ "<th>Postal Address</th>"
		 		+"<th>Postal Code</th>"
		 		+"<th>Product Name</th>"
		 		+"<th>Product Itemcode</th>"
		 		+"<th>Product Stock</th>"
		 		+"<th>Product Description</th>"
		 	    +"<th>Order Received</th>"
		 	    + "<th>Report</th>"
		 	    + "</tr>";

		 String query = "select p.paymantID,p.paymentType,p.paymentAmount,p.paymentDate,p.paymentPostaladdress,p.paymentPostalcode,pro.productName,pro.productItemcode,pro.productStock,pro.productDescription From product pro INNER JOIN payment p ON (p.productID=pro.productID) where p.buyerID=?";
		 PreparedStatement stmt = con.prepareStatement(query);

		 stmt.setInt(1,buyerId);
		 ResultSet rs = stmt.executeQuery();
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String paymantID  = Integer.toString(rs.getInt("paymantID"));
		 String paymentType = rs.getString("paymentType");
		 String paymentAmount = rs.getString("paymentAmount");
		 Date paymentDate = rs.getDate("paymentDate");
		 String paymentPostaladdress = rs.getString("paymentPostaladdress");
		 String paymentPostalcode =rs.getString("paymentPostalcode");
		 String productName=rs.getString("productName");
		 String productItemcode=rs.getString("productItemcode");
		 String productStock=rs.getString("productStock");
		 String productDescription=rs.getString("productDescription");

		 
		 // Add into the html table
		 output += "<tr><td>" + paymantID + "</td>";
		 output += "<td>" + paymentType + "</td>";
		 output += "<td>" + paymentAmount + "</td>";
		 output += "<td>" + paymentDate + "</td>";
		 output += "<td>" + paymentPostaladdress + "</td>";
		 output += "<td>" + paymentPostalcode + "</td>";
		 output += "<td>"+productName+"</td>";
		 output += "<td>"+productItemcode+"</td>";
		 output += "<td>"+productStock+"</td>";
		 output += "<td>"+productDescription+"</td>";

		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Sucess'class='btn btn-secondary'></td>" + "<td><form method='post' action='Payments.jsp'>" + "<input name='btnRemove' type='submit' value='Report'class='btn btn-danger'>"
		 + "<input name='paymantID' type='hidden' value='" + paymantID
		 + "'>" + "</form></td></tr>";
		 }
		 //Connection Close
		 con.close();
		 
		 // Complete the html table
		 output += "</table>";
		 }
		 catch (Exception e)
		 {
		 output = "Error while reading the items.";
		 System.err.println(e.getMessage());
		 }
		 return output;
	}
//**************************************View  Bought Product Payment Details For Researchers**********************************************
	public String ViewBoughtPayments(int researchrID) {
		// TODO Auto-generated method stub
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		
		 // Prepare the html table to be displayed
		 output = "<table border='1'>"
		 		+ "<tr>"
				+"<th>Payment_ID</th>"
		 		+ "<th>Payment Type</th>"
		 		+ "<th>Amount</th>"
		 		+ "<th>Date</th>"
		 		+ "<th>Postal Address</th>"
		 		+"<th>Postal Code</th>"
		 		+"<th>Product Name</th>"
		 		+"<th>Product Itemcode</th>"
		 		+"<th>Product Stock</th>"
		 		+"<th>Product Description</th>"
		        +"<th>Buyer First Name</th>"
		 		+"<th>Buyer Last Name</th>"
		        +"<th>Buyer Email</th>"
		        +"<th>Buyer Contact Number</th>"
		 	    + "</tr>";

		 String query = "select p.paymantID,p.paymentType,p.paymentAmount,p.paymentDate,p.paymentPostaladdress,p.paymentPostalcode,pro.productName,pro.productItemcode,pro.productStock,pro.productDescription,b.buyerFname,b.buyerLname,b.buyerEmail,b.buyerPhone From(( product pro INNER JOIN payment p ON (p.productID=pro.productID) )INNER JOIN buyer b ON  (p.buyerID=b.buyerID)) where pro.researcherID=?";
		 PreparedStatement stmt = con.prepareStatement(query);

		 stmt.setInt(1,researchrID);
		 ResultSet rs = stmt.executeQuery();
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String paymantID  = Integer.toString(rs.getInt("paymantID"));
		 String paymentType = rs.getString("paymentType");
		 String paymentAmount = rs.getString("paymentAmount");
		 Date paymentDate = rs.getDate("paymentDate");
		 String paymentPostaladdress = rs.getString("paymentPostaladdress");
		 String paymentPostalcode =rs.getString("paymentPostalcode");
		 String productName=rs.getString("productName");
		 String productItemcode=rs.getString("productItemcode");
		 String productStock=rs.getString("productStock");
		 String productDescription=rs.getString("productDescription");
		 String buyerFname=rs.getString("buyerFname");
		 String buyerLname=rs.getString("buyerLname");
		 String buyerEmail=rs.getString("buyerEmail");
		 String buyerPhone=rs.getString("buyerPhone");
		
		 // Add into the html table
		 output += "<tr><td>" + paymantID + "</td>";
		 output += "<td>" + paymentType + "</td>";
		 output += "<td>" + paymentAmount + "</td>";
		 output += "<td>" + paymentDate + "</td>";
		 output += "<td>" + paymentPostaladdress + "</td>";
		 output += "<td>" + paymentPostalcode + "</td>";
		 output += "<td>"+productName+"</td>";
		 output += "<td>"+productItemcode+"</td>";
		 output += "<td>"+productStock+"</td>";
		 output += "<td>"+productDescription+"</td>";
		 output += "<td>"+buyerFname+"</td>";
		 output += "<td>"+buyerLname+"</td>";
		 output +="<td>"+buyerEmail+"</td>";
		 output += "<td>"+buyerPhone+"</td>";
		 }
		 //Connection close
		 con.close();
		 
		 // Complete the html table
		 output += "</table>";
		 }
		 catch (Exception e)
		 {
		 output = "Error while reading the items.";
		 System.err.println(e.getMessage());
		 }
		 return output;

	}

}
