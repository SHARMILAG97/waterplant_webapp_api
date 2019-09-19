package com.revature.controller;

import java.util.List;

import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.revature.model.User;
import com.revature.service.UserService;

public class UserController {

	public static String login(long mobile, String password) {
	
		String errorMessage = null;
		
		 UserService user=new UserService();;
        User u1 =null;
        try {
        	
        	u1=new User();
        	
            u1=user.getUser(mobile, password);
            if(u1==null) {
                throw new Exception("Invalid mobileno and Password");
            }
            
        } catch (Exception e) {
          
            errorMessage = e.getMessage();
        }
        
        String json = null;
       Gson gson = new Gson();
       if(u1!=null) {
           json = gson.toJson(u1);
       }
       else if ( u1 == null ) {
           JsonObject obj = new JsonObject();
           obj.addProperty("errorMessage", errorMessage);
           json = obj.toString();
       }
        return json;
        
    }
    
	public static String register(String name, Long mobile, String password, String address) {
		
		String errorMessage = null;
		String Message = null;
		UserService user=new UserService();;
        User u1 =null;
        try {
        	
        	u1 = new User();
        	u1.setName(name);
        	u1.setMobileno(mobile);
        	u1.setPwd(password);
        	u1.setAddress(address);
            user.registerUser(u1);
           Message="Success";  
        }catch (Exception e) {
          
            errorMessage = e.getMessage();
        }
        JsonObject obj = new JsonObject();
        
        if(Message!=null)
        	obj.addProperty("Message", Message);
        else if(errorMessage!=null)
        	obj.addProperty("errorMessage", errorMessage);
		
		return obj.toString();
	}
	

	public List<User> viewUsers() {
		
		List<User> list = null; 
		try {
			
			UserService user = new UserService();
			list=user.viewUsers();
			
			} catch (Exception e) {
			e.printStackTrace();
		}		return list;
	}
	
	
	
    public static void main(String[] args) {
            System.out.println("Test Case 1: Valid User login");
          String validUserJson = UserController.login(8300823797l, "sharmi");
           System.out.println(validUserJson);
            
            System.out.println("Test Case 2: Invalid User login");
           String invalidUserJson = UserController.login(77777777777l, "invalidpassword");
            System.out.println(invalidUserJson);
            
        }


	
	

}
