package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the theater_booking database table.
 * 
 */
@Entity
@Table(name="theater_booking")
@NamedQuery(name="TheaterBooking.findAll", query="SELECT t FROM TheaterBooking t")
public class TheaterBooking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="booking_id")
	private int bookingId;

	private String status;

	private String username;

	//bi-directional many-to-one association to ArtistEvent
	@ManyToOne
	@JoinColumn(name="event_id")
	private ArtistEvent artistEvent;

	public TheaterBooking() {
	}

	public int getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArtistEvent getArtistEvent() {
		return this.artistEvent;
	}

	public void setArtistEvent(ArtistEvent artistEvent) {
		this.artistEvent = artistEvent;
	}

}