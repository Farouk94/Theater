package com.artist;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import com.model.Artist;
import com.model.ArtistEvent;
import com.model.TheaterSeat;
import com.model.UserRegistration;

public class ArtistDAO {

	public static final String  SEAT_STATUS_BOOKED = "Booked";
	public static final String  SEAT_STATUS_AVAILABLE = "Available";
	
	public Map<Integer, String> getEventList() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("theater-app");
		EntityManager entitymanager = emfactory.createEntityManager();

		Map<Integer, String> eventMap = new LinkedHashMap<Integer, String>();

		CriteriaQuery<ArtistEvent> criteria = entitymanager.getCriteriaBuilder().createQuery(ArtistEvent.class);
		criteria.select(criteria.from(ArtistEvent.class));
		List<ArtistEvent> listOfArtistEvent = entitymanager.createQuery(criteria).getResultList();

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

		entitymanager.clear();
		entitymanager.close();
		emfactory.close();
		return eventMap;
	}

	public int getBasePrice(int eventId) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("theater-app");
		EntityManager entitymanager = emfactory.createEntityManager();

		ArtistEvent event = entitymanager.find(ArtistEvent.class, eventId);

		Artist artist = event.getArtist();
		int basePrice = artist.getArtistDetail().getArtistBaseprice();
		entitymanager.clear();
		entitymanager.close();
		emfactory.close();
		return basePrice;
	}

	public Map<String, Boolean> isUserRegistered(String userName, String password) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("theater-app");
		EntityManager entitymanager = emfactory.createEntityManager();
		String pwd = "";
		
		boolean isValidPwd = false;
		boolean isUserValid = false;
		LinkedHashMap<String, Boolean> userDetails= new LinkedHashMap<String, Boolean>();
		UserRegistration user = entitymanager.find(UserRegistration.class, userName);

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
		
		entitymanager.clear();
		entitymanager.close();
		emfactory.close();
		
		return userDetails;
	}
	
	public Boolean validateAdminLogin(String userName, String password) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("theater-app");
		EntityManager entitymanager = emfactory.createEntityManager();
		String pwd = "";
		
		boolean isValidPwd = false;
		LinkedHashMap<String, Boolean> userDetails= new LinkedHashMap<String, Boolean>();
		UserRegistration user = entitymanager.find(UserRegistration.class, userName);

		if (user != null) {
			pwd = user.getPassword() != null ? user.getPassword() : "";
			if (pwd.equals(password)) {
				isValidPwd = true;
			} else {
				isValidPwd = false;
			}
		} 
		
		entitymanager.clear();
		entitymanager.close();
		emfactory.close();
		return isValidPwd;
		
	}

	public void registerUser(String name, String pwd, String email) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("theater-app");
		EntityManager entitymanager = emfactory.createEntityManager();

		entitymanager.getTransaction().begin();

		UserRegistration user = new UserRegistration();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(pwd);

		entitymanager.persist(user);

		entitymanager.getTransaction().commit();

		entitymanager.clear();
		entitymanager.close();
		emfactory.close();
	}

	public void seatBooking(String seatNumber) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("theater-app");
		EntityManager entitymanager = emfactory.createEntityManager();

		TheaterSeat seat = entitymanager.find(TheaterSeat.class, seatNumber);
		 
		if(seat.getStatus().equals(SEAT_STATUS_AVAILABLE))
		{
		entitymanager.getTransaction().begin();
		seat.setStatus(SEAT_STATUS_BOOKED);
		entitymanager.getTransaction().commit();
		}
		
		entitymanager.clear();
		entitymanager.close();
		emfactory.close();
	}
	
	public void deallocateSeat(String seatNumber) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("theater-app");
		EntityManager entitymanager = emfactory.createEntityManager();

		TheaterSeat seat = entitymanager.find(TheaterSeat.class, seatNumber);
		 
		if(seat.getStatus().equals(SEAT_STATUS_BOOKED))
		{
		entitymanager.getTransaction().begin();
		seat.setStatus(SEAT_STATUS_AVAILABLE);
		entitymanager.getTransaction().commit();
		}
		
		entitymanager.clear();
		entitymanager.close();
		emfactory.close();
	}
	
	
	
	public Map<String, String> seatStatus() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("theater-app");
		EntityManager entitymanager = emfactory.createEntityManager();

		CriteriaQuery<TheaterSeat> criteria = entitymanager.getCriteriaBuilder().createQuery(TheaterSeat.class);
		criteria.select(criteria.from(TheaterSeat.class));
		List<TheaterSeat> listOfSeats = entitymanager.createQuery(criteria).getResultList();

		Map<String,String> seatStatusMap = new TreeMap<String,String>();
		for(TheaterSeat seat : listOfSeats)	
		{
			seatStatusMap.put(seat.getSeatNumber(), seat.getStatus());
		}
		entitymanager.clear();
		entitymanager.close();
		emfactory.close();
		return seatStatusMap;
	}
	
	public Map<String, Integer> adminDetails() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("theater-app");
		EntityManager entitymanager = emfactory.createEntityManager();

		CriteriaQuery<TheaterSeat> criteria = entitymanager.getCriteriaBuilder().createQuery(TheaterSeat.class);
		criteria.select(criteria.from(TheaterSeat.class));
		List<TheaterSeat> listOfSeats = entitymanager.createQuery(criteria).getResultList();

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
		
		entitymanager.clear();
		entitymanager.close();
		emfactory.close();
		return seatStatusMap;
	}
	
}
