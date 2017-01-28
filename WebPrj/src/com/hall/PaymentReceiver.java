package com.hall;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PaymentReceiver extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException 
		  {
		    // reading the user input
		   String startTime= request.getParameter("startTime");
		   String seatNumber= request.getParameter("seatNumber");
		  //Redirect it to photo page
		    RequestDispatcher rd = request.getRequestDispatcher
		        ("/entercarddetail.jsp");
		    
		    request.setAttribute("startTime", startTime);
		    request.setAttribute("seatNumber", seatNumber);
		    
		    rd.forward(request, response);
		  }  

}

