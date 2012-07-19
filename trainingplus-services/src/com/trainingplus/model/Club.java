package com.trainingplus.model;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Un club de sport.
 * 
 * @author Maxime Gréau <maxime.greau@fiaveo.fr>
 * 
 */
@Entity
public class Club  {

	/** Nom du club */
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
