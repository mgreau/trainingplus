package com.trainingplus.server.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.googlecode.objectify.Key;



/**
 * La saison sportive d'un club.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
public class SeasonClub {
	
	@Id Long id;
	
	/** Le club */
	private Key<Club> club;
	
	/** La saison sportive */
	private Key<Season> season;
	
	@SuppressWarnings("unused")
	private SeasonClub(){
		
	}

	public SeasonClub(Key<Club> club, Key<Season> season) {
		super();
		this.club = club;
		this.season = season;
	}
	
	public SeasonClub(Club club, Season season) {
		super();
		this.club = new Key<Club>(Club.class, club.id);
		this.season = new Key<Season>(Season.class, season.id);
	}

	public Key<Club> getClub() {
		return club;
	}

	public void setClub(Key<Club> club) {
		this.club = club;
	}

	public Key<Season> getSeason() {
		return season;
	}

	public void setSeason(Key<Season> season) {
		this.season = season;
	}

	public Long getId() {
		return id;
	}
	

}
