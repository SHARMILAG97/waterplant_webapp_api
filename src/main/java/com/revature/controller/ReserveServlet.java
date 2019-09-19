package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reserve;

public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
       
		
	String reservecans= request.getParameter("reservecans");
	int rcans = Integer.parseInt(reservecans);
	String Uid= request.getParameter("Id");
	int Userid = Integer.parseInt(Uid);
	String name = request.getParameter("Name");
	String address = request.getParameter("Address");
	String mobileno = request.getParameter("Mobileno");
	Long mobile = Long.parseLong(mobileno);
	
	Reserve rev = new Reserve();
	
	rev.setRUId(Userid);
	rev.setRUName(name);
	rev.setRUMobileno(mobile);
	rev.setRUAddress(address);
	
	
    
   String json = ReserveController.reserve(rev,rcans);

 
    HttpSession session = request.getSession();
	session.setAttribute("LOGGED_IN_USER",json);
	
   PrintWriter out = response.getWriter();
   out.write(json);
   out.flush();    

}}