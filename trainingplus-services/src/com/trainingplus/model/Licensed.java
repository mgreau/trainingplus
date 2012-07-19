package com.trainingplus.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


/**
 * Les inscrits au club pour une saison sportive.
 * 
 * @author Maxime Gréau <maxime.greau@fiaveo.fr>
 * 
 */
@Entity
public class Licensed {

	/** La saison sportive du club */
	@ManyToOne
	public SeasonClub seasonClub;

	/** La personne */
	@ManyToOne
	public Person person;

	/**
	 * La date d'inscription de la personne dans le club pour cette saison (par
	 * défaut la date de début de saison
	 */
	public Date startDate;

	/** La date de sortie du club de la personne (par défaut la date de fin de saison) */
	public Date endDate;

	public Licensed(SeasonClub seasonClub, Person person) {
		super();
		this.seasonClub = seasonClub;
		this.person = person;
	}
	
	/**
	 * @return representation lisible de l'objet
	 */
	public String toString() {
		return this.person + " " + this.seasonClub;
	}

}
