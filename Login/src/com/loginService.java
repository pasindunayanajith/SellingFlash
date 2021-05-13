package com;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.login;
import model.loginPOJO;

public class loginService {
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public loginPOJO getAppointmentbypatient(String appointmentData) {
		System.out.println(appointmentData);
		JsonObject jsonObject = new JsonParser().parse(appointmentData).getAsJsonObject();
	
		loginPOJO loginPOJO = new loginPOJO();
		
		loginPOJO.setUname(jsonObject.get("email").getAsString());
		loginPOJO.setPassword(jsonObject.get("password").getAsString());
		String type =jsonObject.get("type").getAsString();
		
		login login = new login();
		
		
		return login.userLogin(loginPOJO, type);
	}
}
