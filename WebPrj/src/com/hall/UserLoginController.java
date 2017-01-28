package com.hall;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	UserLogin userLoginSessionBeanLocal;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reading the user input
		String userName = request.getParameter("uname");
		String userPwd = request.getParameter("psw");

		String errorMessage = "";
		Map<String, Boolean> userDetails = new LinkedHashMap<String, Boolean>();
		//userDetails = (LinkedHashMap<String, Boolean>) new ArtistDAO().isUserRegistered(userName, userPwd);
		userDetails = userLoginSessionBeanLocal.isUserRegistered(userName, userPwd);

		if (userDetails.get("isUserValid")) {

			if (userDetails.get("isPasswordValid")) {

				// Redirect it to home page
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
				
				rd.forward(request, response);
			} else {

				errorMessage = " Incorrect Password.";
				// Redirect it to login page
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("errorMessage", errorMessage);

				rd.forward(request, response);
			}
		} else {

			errorMessage = "User doesn't exist. Please Signup to continue";

			// Redirect it to login page
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("errorMessage", errorMessage);
			rd.forward(request, response);
		}

	}

}
