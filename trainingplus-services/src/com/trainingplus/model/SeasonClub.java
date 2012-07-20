package com.trainingplus.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


/**
 * La saison sportive d'un club.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
public class SeasonClub {
	
	/** Le club */
	@ManyToOne
	public Club club;
	
	/** La saison sportive */
	@ManyToOne
	public Season season;

	public SeasonClub(Club club, Season season) {
		super();
		this.club = club;
		this.season = season;
	}
	
	/**
	 * @return representation lisible de l'objet
	 */
	public String toString() {
		return this.club + " " + this.season;
	}

}
