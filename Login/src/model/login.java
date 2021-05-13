package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {
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
	
	public loginPOJO userLogin(loginPOJO loginPOJO,String type) {
		loginPOJO pojo = new loginPOJO();

		try {
			Connection con = connect();

			if (con == null) {
				return pojo;
			}

			String querybuyer = "SELECT `buyerID`, `buyerFname` FROM `buyer` WHERE `buyerEmail` = ? AND `buyerPassword` = ?";
			String queryfundingbodie = "SELECT `fbID`, `fbName` FROM `fundingbodies` WHERE `fbEmail` = ? AND `fbPassword` = ?";
			String queryresearcher= "SELECT `researcherID`, `researcherFname` FROM `researcher` WHERE  `researcherEmail` = ? AND `researcherPassword` = ?";
			
			if(type.equals("Admin")) {
				
				if(loginPOJO.getUname().equals("Admin@admin.com") && loginPOJO.getPassword().equals("admin")) {
					pojo.setType("Admin");
					pojo.setMesage("Login Sucsses");
					
				}else {
					pojo.setMesage("incorrect username or password");
				}
				
			}else if(type.equals("Buyer")) {
				PreparedStatement statement = con.prepareStatement(querybuyer);

				statement.setString(1,loginPOJO.uname);
				statement.setString(2,loginPOJO.password);
				ResultSet set = statement.executeQuery();

				if(set.next()) {
					pojo.setType(type);
					pojo.setMesage("Login Sucsses");
					pojo.setName(set.getString("buyerFname"));
					pojo.setId(set.getInt("buyerID"));
				}else {
					pojo.setMesage("incorrect username or password");
				}
				
				
				
			}else if(type.equals("FundingBodie")) {
				PreparedStatement statement = con.prepareStatement(queryfundingbodie);

				statement.setString(1,loginPOJO.uname);
				statement.setString(2,loginPOJO.password);
				ResultSet set = statement.executeQuery();

				if(set.next()) {
					pojo.setType(type);
					pojo.setMesage("Login Sucsses");
					pojo.setName(set.getString("fbName"));
					pojo.setId(set.getInt("fbID"));
				}else {
					pojo.setMesage("incorrect username or password");
				}
				
				
				
			}else if(type.equals("Researcher")) {
				PreparedStatement statement = con.prepareStatement(queryresearcher);

				statement.setString(1,loginPOJO.uname);
				statement.setString(2,loginPOJO.password);
				ResultSet set = statement.executeQuery();

				if(set.next()) {
					pojo.setType(type);
					pojo.setMesage("Login Sucsses");
					pojo.setName(set.getString("researcherFname"));
					pojo.setId(set.getInt("researcherID"));
				}else {
					pojo.setMesage("incorrect username or password");
				}
				
			}
		
					
			//connection close
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return pojo;
	}
}
