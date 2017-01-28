package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the theater_seat database table.
 * 
 */
@Entity
@Table(name="theater_seat")
@NamedQuery(name="TheaterSeat.findAll", query="SELECT t FROM TheaterSeat t")
public class TheaterSeat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String seatNumber;

	private String status;

	public TheaterSeat() {
	}

	public String getSeatNumber() {
		return this.seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}