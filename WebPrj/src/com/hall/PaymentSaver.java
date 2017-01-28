package com.hall;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymentController")
public class PaymentSaver extends HttpServlet {

	private static final long serialVersionUID = 1L;


	@EJB
	UserLogin userLoginSessionBeanLocal;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reading the user input
		String cardNumber = request.getParameter("cardNumber");
		String name = request.getParameter("name");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String cvv = request.getParameter("cvv");
		String seatNumber = request.getParameter("seatNumber");
		long startTime = Long.parseLong(request.getParameter("startTime"));

		long paymentSubmissionTime = System.currentTimeMillis();

		long diff = paymentSubmissionTime - startTime;

		long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

		System.out.println("User's Choice" + cardNumber + name + month + year + cvv);

		System.out.println("Diff in minutes" + diff);
		System.out.println("startTime " + startTime);
		System.out.println("Booked Seat" + seatNumber);

		if (minutes > 1) {
			String[] seats = seatNumber.split(",");
			for (int i = 0; i < seats.length; i++) {
				System.out.println("splitString[" + i + "] is " + seats[i]);
				userLoginSessionBeanLocal.deallocateSeat(seats[i]);
			}

			// Redirect it to photo page
			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			request.setAttribute("timeExceededError", "Time Limit has been exceeded, please book within 5 minutes");
			rd.forward(request, response);
		} else

		{

			// Redirect it to photo page
			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");

			rd.forward(request, response);
		}
	}

}
