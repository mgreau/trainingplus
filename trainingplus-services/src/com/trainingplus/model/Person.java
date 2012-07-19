package com.trainingplus.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Une personne dans le système de gestion de club.
 * 
 * @author Maxime Gréau <maxime.greau@fiaveo.fr>
 *
 */
@Entity
public class Person {
	
	@Id Long id;
	
	/** Nom de famille de la personne */
	public String name;
	
	/** Prénom de la personne */
	public String firstName;
	
	/** Date de naissance de la personne */
	public Date birthday;
	
	/** Adresse email de la personne */
    public String email;

	public Person(String name, String firstName, Date birthday, String email) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.birthday = birthday;
		this.email = email;
	}
	
	public Person(String name, String firstName, Date birthday) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.birthday = birthday;
	}
	
	/**
	 * @return representation lisible de l'objet
	 */
	public String toString() {
		return this.name;
	}
	
	

}
