package com.hall;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HallServlet
 */
@WebServlet("/HallServlet")
public class HallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@EJB
	HallSessionBean hallSessionBean;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("Servlet execution started...");
	
	PrintWriter out = response.getWriter();
	
	out.println(hallSessionBean.gethallSessionBeanMethod());
	
	System.out.println("Servlet execution ended...");
	
	}

}
