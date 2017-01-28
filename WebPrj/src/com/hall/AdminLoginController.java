package com.hall;
import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	UserLogin userLoginSessionBeanLocal;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reading the user input
		String adminName = request.getParameter("adminName");
		String adminPassword = request.getParameter("adminPassword");

		System.out.println("adminName" + "admin");
		
		String errorMessage = "";
		boolean isAdmin = userLoginSessionBeanLocal.validateAdminLogin("admin", adminPassword);

		if (isAdmin) {

			 Map<String, Integer>  seatCountByCategory = userLoginSessionBeanLocal.adminDetails();
			
			// Redirect it to login page
			RequestDispatcher rd = request.getRequestDispatcher("/admindetails.jsp");
			
			request.setAttribute("seatCountByCategory", seatCountByCategory);
			
			rd.forward(request, response);

		} else {
			errorMessage = " Incorrect Password.";
			// Redirect it to login page
			RequestDispatcher rd = request.getRequestDispatcher("/adminLogin.jsp");
			request.setAttribute("errorMessage", errorMessage);

			rd.forward(request, response);
		}
	}

}
