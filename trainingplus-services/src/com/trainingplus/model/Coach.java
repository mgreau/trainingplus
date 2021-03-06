package com.trainingplus.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 * Un entraineur sportif.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Coach extends Person {

    /** Le niveau de diplôme de l'entraineur */
    public String certificate;

	public Coach(String name, String firstName, Date birthday,String certificate) {
		super(name, firstName, birthday);
		this.certificate = certificate;
	}
    
	/**
	 * @return representation lisible de l'objet
	 */
	public String toString() {
		return this.name;
	}
    


}
