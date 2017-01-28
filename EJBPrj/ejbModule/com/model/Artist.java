package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artist database table.
 * 
 */
@Entity
@NamedQuery(name="Artist.findAll", query="SELECT a FROM Artist a")
public class Artist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int artistId;

	@Column(name="name")
	private String artistName;

	@Column(name="SIN")
	private String artistSIN;

	//bi-directional many-to-one association to ArtistDetail
	@ManyToOne
	@JoinColumn(name="artistType")
	private ArtistDetail artistDetail;

	//bi-directional many-to-one association to ArtistEvent
	@OneToMany(mappedBy="artist")
	private List<ArtistEvent> artistEvents;

	public Artist() {
	}

	public int getArtistId() {
		return this.artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return this.artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistSIN() {
		return this.artistSIN;
	}

	public void setArtistSIN(String artistSIN) {
		this.artistSIN = artistSIN;
	}

	public ArtistDetail getArtistDetail() {
		return this.artistDetail;
	}

	public void setArtistDetail(ArtistDetail artistDetail) {
		this.artistDetail = artistDetail;
	}

	public List<ArtistEvent> getArtistEvents() {
		return this.artistEvents;
	}

	public void setArtistEvents(List<ArtistEvent> artistEvents) {
		this.artistEvents = artistEvents;
	}

	public ArtistEvent addArtistEvent(ArtistEvent artistEvent) {
		getArtistEvents().add(artistEvent);
		artistEvent.setArtist(this);

		return artistEvent;
	}

	public ArtistEvent removeArtistEvent(ArtistEvent artistEvent) {
		getArtistEvents().remove(artistEvent);
		artistEvent.setArtist(null);

		return artistEvent;
	}

}