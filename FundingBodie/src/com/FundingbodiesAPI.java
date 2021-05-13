package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;

@WebServlet("/FundingbodiesAPI")
public class FundingbodiesAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	FundingBodie fundingbodieObj = new FundingBodie(); 
    public FundingbodiesAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = fundingbodieObj.insertFundingBodie(request.getParameter("fbName"), 
				request.getParameter("fbAddress"), 
				request.getParameter("fbPhone"), 
				request.getParameter("fbEmail"),
				request.getParameter("fbPassword"),
				request.getParameter("fbDescription")
				

); 
				response.getWriter().write(output);
	}
	
	// Convert request parameters to a Map
	private static Map<String, String> getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 {
		 String[] p = param.split("=");
		 map.put(p[0], p[1]); 
		 } 
		 } 
		catch (Exception e) 
		 { 
		 } 
		return map; 
	}
	 
	

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> paras = getParasMap(request); 
		String output = fundingbodieObj.updateFundingBodie(paras.get("hidFundingbodieIDSave").toString(), 
		paras.get("fbName").toString(), 
		paras.get("fbAddress").toString(), 
		paras.get("fbPhone").toString(),
		paras.get("fbEmail").toString(),
		paras.get("fbPassword").toString(),
		paras.get("fbDescription").toString()); 
		
		response.getWriter().write(output); 
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> paras = getParasMap(request); 
		String output = fundingbodieObj.deleteFundingBodie(paras.get("fbID").toString()); 
		response.getWriter().write(output); 
	}

}
