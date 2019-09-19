package com.revature.controller;

import com.google.gson.JsonObject;
import com.revature.model.Reserve;
import com.revature.service.UserService;

public class ReserveController {

	public static String reserve(Reserve rev, int rcans) {
		
		String errorMessage = null;
		String Message = null;
		UserService user=new UserService();;
       
       
        try {
			user.reserve(rev,rcans);
			Message = "Reserved Successfully";
		} catch (Exception e) {
			
			errorMessage = e.getMessage();			
		}

        JsonObject obj = new JsonObject();
        
        if(Message!=null)
        	obj.addProperty("Message", Message);
        else if(errorMessage!=null)
        	obj.addProperty("errorMessage", errorMessage);
		
		return obj.toString();
	}

}
