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

@WebServlet("/ProductsAPI2")
public class ProductsAPI2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Product productObj = new Product(); 
    public ProductsAPI2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		 String output = productObj.updateProduct(paras.get("hidProductIDSave").toString(), 
		 paras.get("productName").toString(), 
		paras.get("productPrice").toString(),
		paras.get("productStock").toString(), 
		paras.get("productDescription").toString(),	
		paras.get("embledCode1").toString(),
		paras.get("embledCode2").toString(),
		paras.get("delivertime").toString(),
		paras.get("availability").toString(),
		paras.get("approval").toString() );
		response.getWriter().write(output); 
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> paras = getParasMap(request); 
		String output = productObj.deleteProduct(paras.get("productID").toString()); 
		response.getWriter().write(output); 
	}

}
