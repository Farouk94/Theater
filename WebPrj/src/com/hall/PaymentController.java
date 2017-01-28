package com.hall;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UserLogin userLoginSessionBeanLocal;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reading the user input
		long stratTime = System.currentTimeMillis();
		String[] selectedSeatNumbers = request.getParameterValues("seatCheck");
		String basePrice = request.getParameter("basePrice");

		double ticketPrice = 0;
		int seatProcessed = 0;
		
		StringBuffer sb = new StringBuffer();
		for (String seatNumber : selectedSeatNumbers) {
			 
			if(seatProcessed == selectedSeatNumbers.length-1)
			{
				sb.append(seatNumber);
			}else{
				sb.append(seatNumber + ",");
			}
			
			if (seatNumber.contains("A")) {
				ticketPrice = ticketPrice + (3 * Integer.parseInt(basePrice));
				userLoginSessionBeanLocal.seatBooking(seatNumber);
			} else if (seatNumber.contains("B")) {
				ticketPrice = ticketPrice + (2.5 * Integer.parseInt(basePrice));
				userLoginSessionBeanLocal.seatBooking(seatNumber);
			} else if (seatNumber.contains("C")) {
				ticketPrice = ticketPrice + (2 * Integer.parseInt(basePrice));
				userLoginSessionBeanLocal.seatBooking(seatNumber);
			} else if (seatNumber.contains("D")) {
				ticketPrice = ticketPrice + Integer.parseInt(basePrice);
				userLoginSessionBeanLocal.seatBooking(seatNumber);
			}
			seatProcessed ++;
		}

		
		// Redirect it to photo page
		RequestDispatcher rd = request.getRequestDispatcher("/processpayment.jsp");
		request.setAttribute("ticketPrice", ticketPrice);
		request.setAttribute("seatNumber", sb.toString());
		request.setAttribute("startTime",stratTime);
		rd.forward(request, response);
	}

}
