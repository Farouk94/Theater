package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artist_detail database table.
 * 
 */
@Entity
@Table(name="artist_detail")
@NamedQuery(name="ArtistDetail.findAll", query="SELECT a FROM ArtistDetail a")
public class ArtistDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="type")
	private String artistId;

	@Column(name="baseprice")
	private int artistBaseprice;

	@Column(name="category")
	private String artistCategory;

	//bi-directional many-to-one association to Artist
	@OneToMany(mappedBy="artistDetail")
	private List<Artist> artists;

	public ArtistDetail() {
	}

	public String getArtistId() {
		return this.artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public int getArtistBaseprice() {
		return this.artistBaseprice;
	}

	public void setArtistBaseprice(int artistBaseprice) {
		this.artistBaseprice = artistBaseprice;
	}

	public String getArtistCategory() {
		return this.artistCategory;
	}

	public void setArtistCategory(String artistCategory) {
		this.artistCategory = artistCategory;
	}

	public List<Artist> getArtists() {
		return this.artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public Artist addArtist(Artist artist) {
		getArtists().add(artist);
		artist.setArtistDetail(this);

		return artist;
	}

	public Artist removeArtist(Artist artist) {
		getArtists().remove(artist);
		artist.setArtistDetail(null);

		return artist;
	}

}