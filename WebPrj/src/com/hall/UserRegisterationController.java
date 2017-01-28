package com.hall;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegisterationController")
public class UserRegisterationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	UserLogin userLoginSessionBeanLocal;
	protected void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException 
		  {
		    // reading the user input
		    String userName= request.getParameter("uname");  
		    String userPwd= request.getParameter("password");
		    String userEmail= request.getParameter("email");
		    
		    userLoginSessionBeanLocal.registerUser(userName,userPwd, userEmail);
		  //Redirect it to seat page
		    RequestDispatcher rd = request.getRequestDispatcher
		        ("/login.jsp");
		    
		    rd.forward(request, response);
		  }  

}
