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

@WebServlet("/ResearchersAPI")
public class ResearchersAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Researcher researcherObj = new Researcher(); 
    public ResearchersAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = researcherObj.insertResearcher(request.getParameter("researcherFname"), 
				request.getParameter("researcherLname"), 
				request.getParameter("researcherGender"), 
				request.getParameter("researcherNic"),
				request.getParameter("researcherPhone"),
				request.getParameter("researcherBirthday"),
				request.getParameter("researcherEmail"),
				request.getParameter("researcherPassword"),
				request.getParameter("researchDetails"),
				request.getParameter("accountnumber"),
				request.getParameter("bankname")

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
		 String output = researcherObj.updateResearcher(paras.get("hidResearcherIDSave").toString(), 
		 paras.get("researcherFname").toString(), 
		 paras.get("researcherLname").toString(), 
		paras.get("researcherGender").toString(),
		paras.get("researcherNic").toString(), 
		paras.get("researcherPhone").toString(),
		paras.get("researcherBirthday").toString(),
		paras.get("researcherEmail").toString(),
		paras.get("researcherPassword").toString(),
		paras.get("researchDetails").toString(),
		paras.get("accountnumber").toString(),
		paras.get("bankname").toString()); 

		response.getWriter().write(output); 
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> paras = getParasMap(request); 
		String output = researcherObj.deleteResearcher(paras.get("researcherID").toString()); 
		response.getWriter().write(output); 
	}

}
