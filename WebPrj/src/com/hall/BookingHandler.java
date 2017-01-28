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

@WebServlet("/BookingHandler")
public class BookingHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	UserLogin userLoginSessionBeanLocal;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reading the user input
		String eventId = request.getParameter("submitEventId");

		System.out.println("User's Choice" + eventId);

		//int basePrice = new ArtistDAO().getBasePrice(Integer.parseInt(eventId));
		int basePrice = userLoginSessionBeanLocal.getBasePrice(Integer.parseInt(eventId));
		
		//Map<String, String> seatStatusMap = new ArtistDAO().seatStatus();
		Map<String, String> seatStatusMap = userLoginSessionBeanLocal.seatStatus();

		seatStatusMap = getSortedSeatMap(seatStatusMap);

		// Redirect it to seat page
		RequestDispatcher rd = request.getRequestDispatcher("/advanceseatselection.jsp");
		request.setAttribute("basePrice", basePrice);
		request.setAttribute("seatStatusMap", seatStatusMap);
		rd.forward(request, response);
	}

	public Map<String, String> getSortedSeatMap(Map<String, String> seatStatusMap) {

		Map<String, String> seatMap = new LinkedHashMap<String, String>();
		
		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A1)) {

			seatMap.put(TheaterSeatDetail.SEAT_A1, seatStatusMap.get(TheaterSeatDetail.SEAT_A1));
		}
		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A2)) {

			seatMap.put(TheaterSeatDetail.SEAT_A2, seatStatusMap.get(TheaterSeatDetail.SEAT_A2));
		}
		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A3)) {

			seatMap.put(TheaterSeatDetail.SEAT_A3, seatStatusMap.get(TheaterSeatDetail.SEAT_A3));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A4)) {

			seatMap.put(TheaterSeatDetail.SEAT_A4, seatStatusMap.get(TheaterSeatDetail.SEAT_A4));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A5)) {

			seatMap.put(TheaterSeatDetail.SEAT_A5, seatStatusMap.get(TheaterSeatDetail.SEAT_A5));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A6)) {

			seatMap.put(TheaterSeatDetail.SEAT_A6, seatStatusMap.get(TheaterSeatDetail.SEAT_A6));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A7)) {

			seatMap.put(TheaterSeatDetail.SEAT_A7, seatStatusMap.get(TheaterSeatDetail.SEAT_A7));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A8)) {

			seatMap.put(TheaterSeatDetail.SEAT_A8, seatStatusMap.get(TheaterSeatDetail.SEAT_A8));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A9)) {

			seatMap.put(TheaterSeatDetail.SEAT_A9, seatStatusMap.get(TheaterSeatDetail.SEAT_A9));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A10)) {

			seatMap.put(TheaterSeatDetail.SEAT_A10, seatStatusMap.get(TheaterSeatDetail.SEAT_A10));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A11)) {

			seatMap.put(TheaterSeatDetail.SEAT_A11, seatStatusMap.get(TheaterSeatDetail.SEAT_A11));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A12)) {

			seatMap.put(TheaterSeatDetail.SEAT_A12, seatStatusMap.get(TheaterSeatDetail.SEAT_A12));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A13)) {

			seatMap.put(TheaterSeatDetail.SEAT_A13, seatStatusMap.get(TheaterSeatDetail.SEAT_A13));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A14)) {

			seatMap.put(TheaterSeatDetail.SEAT_A14, seatStatusMap.get(TheaterSeatDetail.SEAT_A14));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_A15)) {

			seatMap.put(TheaterSeatDetail.SEAT_A15, seatStatusMap.get(TheaterSeatDetail.SEAT_A15));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B1)) {

			seatMap.put(TheaterSeatDetail.SEAT_B1, seatStatusMap.get(TheaterSeatDetail.SEAT_B1));
		}
		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B2)) {

			seatMap.put(TheaterSeatDetail.SEAT_B2, seatStatusMap.get(TheaterSeatDetail.SEAT_B2));
		}
		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B3)) {

			seatMap.put(TheaterSeatDetail.SEAT_B3, seatStatusMap.get(TheaterSeatDetail.SEAT_B3));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B4)) {

			seatMap.put(TheaterSeatDetail.SEAT_B4, seatStatusMap.get(TheaterSeatDetail.SEAT_B4));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B5)) {

			seatMap.put(TheaterSeatDetail.SEAT_B5, seatStatusMap.get(TheaterSeatDetail.SEAT_B5));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B6)) {

			seatMap.put(TheaterSeatDetail.SEAT_B6, seatStatusMap.get(TheaterSeatDetail.SEAT_B6));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B7)) {

			seatMap.put(TheaterSeatDetail.SEAT_B7, seatStatusMap.get(TheaterSeatDetail.SEAT_B7));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B8)) {

			seatMap.put(TheaterSeatDetail.SEAT_B8, seatStatusMap.get(TheaterSeatDetail.SEAT_B8));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B9)) {

			seatMap.put(TheaterSeatDetail.SEAT_B9, seatStatusMap.get(TheaterSeatDetail.SEAT_B9));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B10)) {

			seatMap.put(TheaterSeatDetail.SEAT_B10, seatStatusMap.get(TheaterSeatDetail.SEAT_B10));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B11)) {

			seatMap.put(TheaterSeatDetail.SEAT_B11, seatStatusMap.get(TheaterSeatDetail.SEAT_B11));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B12)) {

			seatMap.put(TheaterSeatDetail.SEAT_B12, seatStatusMap.get(TheaterSeatDetail.SEAT_B12));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B13)) {

			seatMap.put(TheaterSeatDetail.SEAT_B13, seatStatusMap.get(TheaterSeatDetail.SEAT_B13));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B14)) {

			seatMap.put(TheaterSeatDetail.SEAT_B14, seatStatusMap.get(TheaterSeatDetail.SEAT_B14));
		}

		if (seatStatusMap.containsKey(TheaterSeatDetail.SEAT_B15)) {

			seatMap.put(TheaterSeatDetail.SEAT_B15, seatStatusMap.get(TheaterSeatDetail.SEAT_B15));
		}

		return seatMap;

	}

}
