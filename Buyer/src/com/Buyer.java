package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Buyer {
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

	//************************************Insert Data**************************************************	
		public String insertBuyer(String fname,String lname ,String gender,String address, String phone,String nic ,String birthday,String email,String password)
		 {
		 
			String output = "";
		
		try
		 {
		 Connection con = connect();
		 
		 if (con == null)
		 {return "Error while connecting to the database for inserting."; }
		 
		 // create a prepared statement
		 String query = " insert into buyer(`buyerID`,`buyerFname`,`buyerLname`,`buyerGender`,`buyerAddress`,`buyerPhone`,`buyerNic`,`buyerBirthday`,`buyerEmail`,`buyerPassword`)" + " values (?, ?, ?, ?, ?,?,?,?,?,?)";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, fname);
		 preparedStmt.setString(3, lname);
		 preparedStmt.setString(4, gender);
		 preparedStmt.setString(5, address);
		 preparedStmt.setString(6, phone);
		 preparedStmt.setString(7, nic);
		 preparedStmt.setString(8, birthday);
		 preparedStmt.setString(9, email);
		 preparedStmt.setString(10, password);

		 // execute the statement
		 preparedStmt.execute();
		 //Connection Close
		 con.close();
		 String newBuyers = readBuyer();
		 output = "{\"status\":\"success\", \"data\": \"" + newBuyers + "\"}"; 

		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the buyer.\"}"; 
		System.err.println(e.getMessage());
		}
		return output;
		}
		 


	
		
		//************************************ Read Data********************************************************************************
		public String readBuyer()
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		
		 // Prepare the html table to be displayed
		 output = "<table border='1'>"
		 		+ "<tr>"
				+"<th>Buyer_ID</th>"
		 		+ "<th>FirstName</th>"
		 		+ "<th>LastName</th>"
		 		+ "<th>Gender</th>"
		 		+ "<th>Address</th>"
		 		+"<th>Phone</th>"
		 		+"<th>Nic</th>"
		 		+"<th>Birth Day</th>"
		 		+"<th>Email</th>"
		 		+"<th>Password</th>"
		 	    +"<th>Update</th>"
		 	    + "<th>Remove</th>"
		 	    + "</tr>";

		 String query = "select * from buyer";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String buyerID  = Integer.toString(rs.getInt("buyerID"));
		 String buyerFname = rs.getString("buyerFname");
		 String buyerLname = rs.getString("buyerLname");
		 String buyerGender = rs.getString("buyerGender");
		 String buyerAddress = rs.getString("buyerAddress");
		 String buyerPhone=rs.getString("buyerPhone");
		 String buyerNic = rs.getString("buyerNic");
		 Date buyerBirthday = rs.getDate("buyerBirthday");
		 String buyerEmail = rs.getString("buyerEmail");
		 String buyerPassword = rs.getString("buyerPassword");

		 
		 // Add into the html table
		 output += "<tr><td>" + buyerID + "</td>";
		 output += "<td>" + buyerFname + "</td>";
		 output += "<td>" + buyerLname + "</td>";
		 output += "<td>" + buyerGender + "</td>";
		 output += "<td>" + buyerAddress + "</td>";
		 output += "<td>"+buyerPhone+"</td>";
		 output += "<td>" +buyerNic  + "</td>"; 
		 output += "<td>" +buyerBirthday + "</td>";
		 output += "<td>" +buyerEmail  + "</td>";
		 output += "<td>" +buyerPassword  + "</td>";

		// buttons
			output += "<td><input name='btnUpdate' "
			+ " type='button' value='Update'  class='btnUpdate btn btn-primary' data-buyerid='" + buyerID + "'></td>"
			+ "<td>"
			+ "<input name='btnRemove' "
			+ " type='button' value='Remove' class='btnRemove btn btn-danger' data-buyerid='" + buyerID + "'>"
			+ "</td></tr>";

		 }
		 //Connection Close
		 con.close();
		 
		 // Complete the html table
		 output += "</table>";
		 }
		 catch (Exception e)
		 {
		 output = "Error while reading the buyer.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		
		//************************************************Update Data***************************************************************
		public String updateBuyer(String ID,String fname,String lname ,String gender,String address, String phone,String nic,String birthday,String email,String password)
		{
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE buyer SET buyerFname=?,buyerLname=?,buyerGender=?,buyerAddress=?,buyerPhone=?,buyerNic=?,buyerBirthday=?,buyerEmail=?,buyerPassword=?  WHERE buyerID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, fname);
			 preparedStmt.setString(2, lname);
			 preparedStmt.setString(3, gender);
			 preparedStmt.setString(4, address);
			 preparedStmt.setString(5, phone);
			 preparedStmt.setString(6, nic);
			 preparedStmt.setString(7, birthday);
			 preparedStmt.setString(8, email);
			 preparedStmt.setString(9,password);
			 preparedStmt.setInt(10, Integer.parseInt(ID));
			 // execute the statement
			 preparedStmt.execute();
			
			 // execute the statement
			 preparedStmt.execute();
			 //Connection Close
			 con.close();
			 String newBuyers = readBuyer();
			 output = "{\"status\":\"success\", \"data\": \"" + newBuyers + "\"}"; 
			 
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\": \"Error while upateing the buyer.\"}"; 
			System.err.println(e.getMessage());
			}
			return output;
			}
		
		
		
		//***************************************************Delete data****************************************************
		public String deleteBuyer(String buyerID )
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for deleting."; }
		 // create a prepared statement
		 String query = "delete from buyer where buyerID =?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(buyerID));
		 // execute the statement
		 preparedStmt.execute();
		 //Connection Close
		 con.close();

		
		 String newBuyers = readBuyer();
		 output = "{\"status\":\"success\", \"data\": \"" + newBuyers + "\"}"; 
		 
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while deleteing the buyer.\"}"; 
		System.err.println(e.getMessage());
		}
		return output;
		}
		
		//********************************************************View Profile************************************************
		public String viewProfileBuyers(int buyerId)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		
		 // Prepare the html table to be displayed
		 output = "<table border='1'>"
		 		+ "<tr>"
				+"<th>Buyer_ID</th>"
		 		+ "<th>FirstName</th>"
		 		+ "<th>LastName</th>"
		 		+ "<th>Gender</th>"
		 		+ "<th>Address</th>"
		 		+"<th>Phone</th>"
		 		+"<th>Nic</th>"
		 		+"<th>Birth Day</th>"
		 		+"<th>Email</th>"
		 		+"<th>Password</th>"
		 	    +"<th>Update</th>"
		 	    + "<th>Remove</th>"
		 	    + "</tr>";

		 String query = "select * from buyer where 	buyerID=? ";
		 PreparedStatement stmt = con.prepareStatement(query);

		 stmt.setInt(1,buyerId);
		 ResultSet rs = stmt.executeQuery();
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String buyerID  = Integer.toString(rs.getInt("buyerID"));
		 String buyerFname = rs.getString("buyerFname");
		 String buyerLname = rs.getString("buyerLname");
		 String buyerGender = rs.getString("buyerGender");
		 String buyerAddress = rs.getString("buyerAddress");
		 String buyerPhone=rs.getString("buyerPhone");
		 String buyerNic = rs.getString("buyerNic");
		 Date buyerBirthday = rs.getDate("buyerBirthday");
		 String buyerEmail = rs.getString("buyerEmail");
		 String buyerPassword = rs.getString("buyerPassword");

		 
		 // Add into the html table
		 output += "<tr><td>" + buyerID + "</td>";
		 output += "<td>" + buyerFname + "</td>";
		 output += "<td>" + buyerLname + "</td>";
		 output += "<td>" + buyerGender + "</td>";
		 output += "<td>" + buyerAddress + "</td>";
		 output += "<td>"+buyerPhone+"</td>";
		 output += "<td>" +buyerNic  + "</td>";
		 output += "<td>" +buyerBirthday  + "</td>";
		 output += "<td>" +buyerEmail  + "</td>";
		 output += "<td>" +buyerPassword  + "</td>";

		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>" + "<td><form method='post' action='Buyers.jsp'>" + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
		 + "<input name='buyerID' type='hidden' value='" + buyerID
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

	
		
}
