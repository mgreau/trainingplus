package com.trainingplus.model;
import javax.persistence.Column;
import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * Un club de sport.
 * 
 * @author Maxime Gréau <maxime.greau@fiaveo.fr>
 * 
 */
@Entity
public class Club extends Model {

	/** Nom du club */
	@Required
	@Column(nullable = false)
	public String name;

	public Club(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return representation lisible de l'objet
	 */
	public String toString() {
		return this.name;
	}

}
