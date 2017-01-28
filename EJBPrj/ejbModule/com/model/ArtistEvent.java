package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artist_events database table.
 * 
 */
@Entity
@Table(name="artist_events")
@NamedQuery(name="ArtistEvent.findAll", query="SELECT a FROM ArtistEvent a")
public class ArtistEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int eventId;

	private String eventname;

	//bi-directional many-to-one association to Artist
	@ManyToOne
	@JoinColumn(name="artistId")
	private Artist artist;

	//bi-directional many-to-one association to TheaterBooking
	@OneToMany(mappedBy="artistEvent")
	private List<TheaterBooking> theaterBookings;

	public ArtistEvent() {
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventname() {
		return this.eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public Artist getArtist() {
		return this.artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<TheaterBooking> getTheaterBookings() {
		return this.theaterBookings;
	}

	public void setTheaterBookings(List<TheaterBooking> theaterBookings) {
		this.theaterBookings = theaterBookings;
	}

	public TheaterBooking addTheaterBooking(TheaterBooking theaterBooking) {
		getTheaterBookings().add(theaterBooking);
		theaterBooking.setArtistEvent(this);

		return theaterBooking;
	}

	public TheaterBooking removeTheaterBooking(TheaterBooking theaterBooking) {
		getTheaterBookings().remove(theaterBooking);
		theaterBooking.setArtistEvent(null);

		return theaterBooking;
	}

}