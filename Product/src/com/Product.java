package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Product {

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
		public String insertProduct(String name,String itemcode ,String price,String stock ,String description,String rid,String delivertime,String availability)
		 {
		 
			String output = "";
		
		try
		 {
		 Connection con = connect();
		 
		 if (con == null)
		 {return "Error while connecting to the database for inserting."; }
		 
		 // create a prepared statement
		 String query = " insert into product(`productID`,`productName`,`productItemcode`,`productPrice`,`productStock`,`productDescription`,`researcherID`,`delivertime`,`availability`)" + " values (?, ?, ?, ?, ?,?,?,?,?)";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, name);
		 preparedStmt.setString(3, itemcode);
		 preparedStmt.setDouble(4, Double.parseDouble(price));
		 preparedStmt.setString(5, stock);
		 preparedStmt.setString(6, description);
		 preparedStmt.setInt(7, Integer.parseInt(rid));
		 preparedStmt.setString(8, delivertime);
		 preparedStmt.setString(9, availability);
		
		 		// execute the statement
				 preparedStmt.execute();
				 //Connection Close
				 con.close();
				 String newProducts = readProduct();
				 output = "{\"status\":\"success\", \"data\": \"" + newProducts + "\"}"; 
				 
				}
				catch (Exception e)
				{
					output = "{\"status\":\"error\", \"data\": \"Error while inserting the product.\"}"; 
				System.err.println(e.getMessage());
				}
				return output;
				}
				 
		
		
		//************************************ Read All Product Data For Admin(Can Manage) ********************************************************************************
		public String readProduct()
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
				+"<th>Product_ID</th>"
		 		+ "<th>Product Name</th>"
		 		+ "<th>Itemcode</th>"
		 		+ "<th>Price</th>"
		 		+ "<th>Stock</th>"
		 		+"<th>Description</th>"
		 		+"<th>Researcher Id</th>"
		 		+"<th>Credit/Debit embed</th>"
		 	    +"<th>Paypal embed</th>"
		 		+"<th>Deliver Time</th>"
		 	    +"<th>Availability</th>"
		 		+"<th>Approval</th>"
			    +"<th>Update</th>"
			    +"<th>Delete</th>"
		 	    + "</tr>";

		 String query = "select * from product";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String productID = Integer.toString(rs.getInt("productID"));
		 String productName = rs.getString("productName");
		 String productItemcode = rs.getString("productItemcode");
		 String productPrice = Double.toString(rs.getDouble("productPrice"));
		 String productStock = rs.getString("productStock");
		 String productDescription	=rs.getString("productDescription");
		 String researcherID = Integer.toString(rs.getInt("researcherID"));
		 String embledCode1=rs.getString("embledCode1");
		 String	embledCode2=rs.getString("embledCode2"); 
		 String delivertime=rs.getString("delivertime");
		 String availability=rs.getString("availability");
		 String approval=rs.getString("approval");
		

		 
		 // Add into the html table
		 output += "<tr><td>" + productID + "</td>";
		 output += "<td>" + productName + "</td>";
		 output += "<td>" + productItemcode + "</td>";
		 output += "<td>" + productPrice + "</td>";
		 output += "<td>" + productStock + "</td>";
		 output += "<td>"+productDescription+"</td>";
		 output += "<td>"+researcherID+"</td>";
		 output += "<td>"+embledCode1+"</td>";
		 output += "<td>"+embledCode2+"</td>";
		 output += "<td>"+delivertime+"</td>";
		 output += "<td>"+availability+"</td>";
		 output += "<td>"+approval+"</td>";



			// buttons
				output += "<td><input name='btnUpdate' "
				+ " type='button' value='Update'  class='btnUpdate btn btn-primary' data-productid='" + productID + "'></td>"
				+ "<td>"
				+ "<input name='btnRemove' "
				+ " type='button' value='Remove' class='btnRemove btn btn-danger' data-productid='" + productID + "'>"
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
		
		
		//************************************************Added Product data Update (For Admin)***************************************************************
		public String updateProduct(String ID,String name,String price,String stock, String description,String code1,String code2,String delivertime,String availability,String approval)
		{
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE product SET productName	=?,productPrice=?,productStock=?,productDescription=?,embledCode1=?,embledCode2=?,delivertime=?,availability=?,approval=? WHERE productID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, name);
			 preparedStmt.setString(2, price);
			 preparedStmt.setString(3, stock);
			 preparedStmt.setString(4, description);
			 preparedStmt.setString(5, code1);//null type attribute
			 preparedStmt.setString(6, code2);//null type attribute
			 preparedStmt.setString(7, delivertime);
			 preparedStmt.setString(8, availability);
			 preparedStmt.setString(9, approval);//null type attribute
			 preparedStmt.setInt(10, Integer.parseInt(ID)); 

			// execute the statement
			 preparedStmt.execute();
			 //Connection Close
			 con.close();
			 String newProducts = readProduct();
			 output = "{\"status\":\"success\", \"data\": \"" + newProducts + "\"}"; 
			 
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\": \"Error while updating the product.\"}"; 
			System.err.println(e.getMessage());
			}
			return output;
			}
			 
	
	
		

		//************************************************Added Product data Update (For Resercher)***************************************************************
		public String updateProductResercher(String ID,String name,String price	,String stock, String description,String delivertime,String availability)
		{
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE product SET productName	=?,productPrice=?,productStock=?,productDescription=?,delivertime=?,availability=? WHERE productID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, name);
			 preparedStmt.setString(2, price);
			 preparedStmt.setString(3, stock);
			 preparedStmt.setString(4, description);
			 preparedStmt.setString(5, delivertime);
			 preparedStmt.setString(6, availability);
			 preparedStmt.setInt(7, Integer.parseInt(ID)); 

				// execute the statement
			 preparedStmt.execute();
			 //Connection Close
			 con.close();
			 String newProducts = readProduct();
			 output = "{\"status\":\"success\", \"data\": \"" + newProducts + "\"}"; 
			 
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\": \"Error while Updateing the product.\"}"; 
			System.err.println(e.getMessage());
			}
			return output;
			}
			 
		
		//***************************************************Delete data****************************************************
		
		public String deleteProduct(String productID )
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for deleting."; }
		 // create a prepared statement
		 String query = "delete from product where productID =?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(productID));
		// execute the statement
		 preparedStmt.execute();
		 //Connection Close
		 con.close();
		 String newProducts = readProduct();
		 output = "{\"status\":\"success\", \"data\": \"" + newProducts + "\"}"; 
		 
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the product.\"}"; 
		System.err.println(e.getMessage());
		}
		return output;
		}
		 

	

//******************************Added Own Product View For Researcher*********************************************************************
		public String ViewOwnProducts(int researcherId) {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for reading."; }
			
			 // Prepare the html table to be displayed
			 output = "<table border='1'>"
			 		+ "<tr>"
					+"<th>Product_ID</th>"
			 		+ "<th>Product Name</th>"
			 		+ "<th>Itemcode</th>"
			 		+ "<th>Price</th>"
			 		+ "<th>Stock</th>"
			 		+"<th>Description</th>"
			 		+"<th>Your_Id</th>"
			 		+"<th>Deliver Time</th>"
			 		+"<th>Availability</th>"
			 		+"<th>Approval</th>"
			 	    +"<th>Update</th>"
			 	    + "<th>Remove</th>"
			 	    + "</tr>";

			 String query = "select * from product where researcherID=?";

				PreparedStatement stmt = con.prepareStatement(query);

				stmt.setInt(1,researcherId);
			 ResultSet rs = stmt.executeQuery();
			 // iterate through the rows in the result set
			 while (rs.next())
			 {
			 String productID = Integer.toString(rs.getInt("productID"));
			 String productName = rs.getString("productName");
			 String productItemcode = rs.getString("productItemcode");
			 String productPrice = Double.toString(rs.getDouble("productPrice"));
			 String productStock = rs.getString("productStock");
			 String productDescription	=rs.getString("productDescription");
			 String researcherId1=Integer.toString(rs.getInt("researcherID"));
			 String delivertime	=rs.getString("delivertime");
			 String availability=rs.getString("availability");
             String approvel=rs.getString("approval");
			 
			 // Add into the html table
			 output += "<tr><td>" + productID + "</td>";
			 output += "<td>" + productName + "</td>";
			 output += "<td>" + productItemcode + "</td>";
			 output += "<td>" + productPrice + "</td>";
			 output += "<td>" + productStock + "</td>";
			 output += "<td>"+productDescription+"</td>";
			 output += "<td>"+researcherId1+"</td>";
			 output += "<td>"+delivertime+"</td>";
			 output += "<td>"+availability+"</td>";
			 output += "<td>"+approvel+"</td>";

			
			 // buttons
			 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>" + "<td><form method='post' action='Products.jsp'>" + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
			 + "<input name='productID' type='hidden' value='" + productID
			 + "'>" + "</form></td></tr>";
			 }
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
//***********************************************Dispay Product View For Users*****************************************************************************
		public String productViewForUsers() {
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
						+"<th>Product_ID</th>"
				 		+ "<th>Product Name</th>"
				 		+ "<th>Itemcode</th>"
				 		+ "<th>Price</th>"
				 		+ "<th>Stock</th>"
				 		+"<th>Description</th>"
				 		+"<th>Deliver time</th>"
				 		+"<th>Availability</th>"
				 	    +"<th>Buy</th>"
				 	    + "</tr>";

				 String query = "select * from product";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 // iterate through the rows in the result set
				 while (rs.next())
				 {
				 String productID = Integer.toString(rs.getInt("productID"));
				 String productName = rs.getString("productName");
				 String productItemcode = rs.getString("productItemcode");
				 String productPrice = Double.toString(rs.getDouble("productPrice"));
				 String productStock = rs.getString("productStock");
				 String productDescription	=rs.getString("productDescription");
				 String delivertime = rs.getString("delivertime");
				 String availability = rs.getString("availability");


				 
				 // Add into the html table
				 output += "<tr><td>" + productID + "</td>";
				 output += "<td>" + productName + "</td>";
				 output += "<td>" + productItemcode + "</td>";
				 output += "<td>" + productPrice + "</td>";
				 output += "<td>" + productStock + "</td>";
				 output += "<td>"+productDescription+"</td>";
				 output += "<td>"+delivertime+"</td>";
				 output += "<td>"+availability+"</td>";

				 // buttons
				 output += "<td><button class=\"btn warning\">Buy</button>\r\n"+ ""+ "</td>" ;
				 }
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

	
		
   		
		
}
