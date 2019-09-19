package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String mobileno = request.getParameter("mobileno");
		String password= request.getParameter("password");
		String address = request.getParameter("address");
		Long mobile = Long.parseLong(mobileno);

		String json= UserController.register(name,mobile, password,address);
		PrintWriter out = response.getWriter();
		   out.write(json);
		   out.flush(); 
		
		
		
	}

}
