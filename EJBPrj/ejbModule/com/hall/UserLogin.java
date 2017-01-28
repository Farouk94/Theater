package com.hall;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import com.model.Artist;
import com.model.ArtistEvent;
import com.model.TheaterSeat;
import com.model.UserRegistration;

/**
 * Session Bean implementation class UserLogin
 */
@Stateless
public class UserLogin {

	@PersistenceContext(name = "PU_HALL")
    private EntityManager entityManager;

	public static final String  SEAT_STATUS_BOOKED = "Booked";
	public static final String  SEAT_STATUS_AVAILABLE = "Available";
	
	public Map<String, Boolean> isUserRegistered(String userName, String password) {

		Map<String, Boolean> userDetails = isUserValid(userName,password);
		
		return userDetails;
	}
	
	public int getBasePrice(int eventId) {
		
		ArtistEvent event = entityManager.find(ArtistEvent.class, eventId);

		Artist artist = event.getArtist();
		int basePrice = artist.getArtistDetail().getArtistBaseprice();
		
		return basePrice;
	}

	
	public Map<String, Boolean> isUserValid(String userName, String password) {
		
		String pwd = "";
		
		boolean isValidPwd = false;
		boolean isUserValid = false;
		LinkedHashMap<String, Boolean> userDetails= new LinkedHashMap<String, Boolean>();
		UserRegistration user = entityManager.find(UserRegistration.class, userName);

		if (user != null) {
			isUserValid = true;
			pwd = user.getPassword() != null ? user.getPassword() : "";
			if (pwd.equals(password)) {
				isValidPwd = true;
			} else {
				isValidPwd = false;
			}
		} else{
			
			isUserValid  = false;
		}
		
		userDetails.put("isPasswordValid", isValidPwd);
		userDetails.put("isUserValid", isUserValid);
		
		return userDetails;
	}

	
	public Map<String, String> seatStatus() {

		CriteriaQuery<TheaterSeat> criteria = entityManager.getCriteriaBuilder().createQuery(TheaterSeat.class);
		criteria.select(criteria.from(TheaterSeat.class));
		List<TheaterSeat> listOfSeats = entityManager.createQuery(criteria).getResultList();

		Map<String,String> seatStatusMap = new TreeMap<String,String>();
		for(TheaterSeat seat : listOfSeats)	
		{
			seatStatusMap.put(seat.getSeatNumber(), seat.getStatus());
		}
	
		return seatStatusMap;
	}
	
	public Map<Integer, String> getEventList() {
		Map<Integer, String> eventMap = new LinkedHashMap<Integer, String>();

		CriteriaQuery<ArtistEvent> criteria = entityManager.getCriteriaBuilder().createQuery(ArtistEvent.class);
		criteria.select(criteria.from(ArtistEvent.class));
		List<ArtistEvent> listOfArtistEvent = entityManager.createQuery(criteria).getResultList();

		List<String> eventList = new ArrayList<String>();
		List<Integer> eventIdList = new ArrayList<Integer>();

		for (ArtistEvent event : listOfArtistEvent) {
			eventMap.put(event.getEventId(), event.getEventname());
			eventList.add(event.getEventname());
			eventIdList.add(event.getEventId());
			System.out.println(event.getEventId());
			System.out.println(event.getEventname());
			System.out.println(event.getArtist());

		}

		return eventMap;
	}
	
	public void seatBooking(String seatNumber) {
		
		TheaterSeat seat = entityManager.find(TheaterSeat.class, seatNumber);
		 
		if(seat.getStatus().equals(SEAT_STATUS_AVAILABLE))
		{
		seat.setStatus(SEAT_STATUS_BOOKED);
		}
	
	}
	
	public void deallocateSeat(String seatNumber) {
	
		TheaterSeat seat = entityManager.find(TheaterSeat.class, seatNumber);
		 
		if(seat.getStatus().equals(SEAT_STATUS_BOOKED))
		{
		seat.setStatus(SEAT_STATUS_AVAILABLE);
		}
	
	}

	public Boolean validateAdminLogin(String userName, String password) {
		String pwd = "";
		
		boolean isValidPwd = false;
		UserRegistration user = entityManager.find(UserRegistration.class, userName);

		if (user != null) {
			pwd = user.getPassword() != null ? user.getPassword() : "";
			if (pwd.equals(password)) {
				isValidPwd = true;
			} else {
				isValidPwd = false;
			}
		} 
		return isValidPwd;
		
	}
	
	public Map<String, Integer> adminDetails() {
		CriteriaQuery<TheaterSeat> criteria = entityManager.getCriteriaBuilder().createQuery(TheaterSeat.class);
		criteria.select(criteria.from(TheaterSeat.class));
		List<TheaterSeat> listOfSeats = entityManager.createQuery(criteria).getResultList();

		Map<String,Integer> seatStatusMap = new LinkedHashMap<String,Integer>();
		
		int aCategoryCount = 0;
		int bCategoryCount = 0;
		
		for(TheaterSeat seat : listOfSeats)	
		{
			
			if(seat.getSeatNumber().contains("B") && seat.getStatus().equals(SEAT_STATUS_BOOKED)){
				
				bCategoryCount ++;
			}
			

			if(seat.getSeatNumber().contains("A") && seat.getStatus().equals(SEAT_STATUS_BOOKED)){
				
				aCategoryCount ++;
			}
		}
		
		seatStatusMap.put("aCount", aCategoryCount);
		seatStatusMap.put("bCount", bCategoryCount);
		
		return seatStatusMap;
	}
	
	public void registerUser(String name, String pwd, String email) {

		UserRegistration user = new UserRegistration();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(pwd);
		entityManager.merge(user);
	}
	
}
