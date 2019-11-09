package com.gpo.enquiry;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gpo.dbconnect.DBconnect;;

public class Form extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String enquiry = req.getParameter("enquiry");
		
		System.out.println("Name: "+name+", Phone: "+phone+", Email: "+email+", Enquiry"+enquiry);
			
		DBconnect dbc = new DBconnect();
		dbc.TableAccess(name, phone, email, enquiry);
		
		resp.sendRedirect("thankyou.html");
	}

}