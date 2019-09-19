package com.revature.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.model.User;
import com.revature.service.AdminService;

public class AdminController {

	public static String login(String name, String password) {
	
		String message = null;
		
		AdminService admin = new AdminService();
		User a1=null;
		try {
			a1=admin.adminLogin(name, password);
			
			if(a1==null)
				throw new Exception("Invalid Name or Password");
			
		} catch (Exception e) {
			
			message=e.getMessage();
		}
		
		String json=null;
		Gson gson = new Gson();
		
		if(a1!=null)
			json = gson.toJson(a1);
		
		else if ( a1 == null ) {
	           JsonObject obj = new JsonObject();
	           obj.addProperty("errorMessage", message);
	           json = obj.toString();
		}
		
		return json;
	}
		
		 public static void main(String[] args) {
	            System.out.println("Test Case 1: Valid User login");
	            String validUserJson = AdminController.login("Naresh", "naresh");
	            System.out.println(validUserJson);
	            
	            System.out.println("Test Case 2: Invalid User login");
	            String invalidUserJson = AdminController.login("nar", "invalidpassword");
	            System.out.println(invalidUserJson);
	            
	        }

	}
