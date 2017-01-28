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

@WebServlet("/EventDisplayController")
public class EventDisplayController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UserLogin userLoginSessionBeanLocal;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reading the user input
		String eventName = request.getParameter("name");

		System.out.println("User's Choice" + eventName);

		//Map<Integer, String> eventMap = new ArtistDAO().getEventList();
		
		Map<Integer, String> eventMap = userLoginSessionBeanLocal.getEventList();

		// Redirect it to photo page
		RequestDispatcher rd = request.getRequestDispatcher("/showevents.jsp");
		request.setAttribute("eventListMap", eventMap);
		rd.forward(request, response);
	}

}
