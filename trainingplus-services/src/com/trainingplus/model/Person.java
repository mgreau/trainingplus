package models;

import java.util.Date;

import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * Une personne dans le système de gestion de club.
 * 
 * @author Maxime Gréau <maxime.greau@fiaveo.fr>
 *
 */
@Entity
public class Person extends Model {
	
	/** Nom de famille de la personne */
	@Required
	public String name;
	
	/** Prénom de la personne */
	@Required
	public String firstName;
	
	/** Date de naissance de la personne */
	@Required
	public Date birthday;
	
	/** Adresse email de la personne */
    @Email
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
