package com.trainingplus.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import models.Person;

/**
 * Un joueur.
 * 
 * @author Maxime Gréau <maxime.greau@fiaveo.fr>
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Player extends Person {
	
	/** Le meilleur pied du joueur */
	public String foot;

	public Player(String name, String firstName, Date birthday, String foot) {
		super(name, firstName, birthday);
		this.foot = foot;
	}

}

