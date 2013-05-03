package com.trainingplus.server.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.appengine.labs.repackaged.com.google.common.base.Objects;
import com.googlecode.objectify.annotation.Indexed;
import com.googlecode.objectify.annotation.Unindexed;

/**
 * Une personne dans le système de gestion de club.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 * 
 */
@Entity
public class Person {

	@Id
	Long id;

	/** Nom de famille de la personne */
	@Indexed
	private String name;

	/** Prénom de la personne */
	@Indexed
	private String firstName;

	/** Date de naissance de la personne */
	@Unindexed
	private Date birthday;

	/** Adresse email de la personne */
	@Indexed
	private String email;

	/**
	 * for objectify
	 */
	protected Person() {
	}

	public Person(String name, String email) {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return this.name != null && p.name != null
					&& p.name.equals(this.name) && this.email != null
					&& p.email != null && p.email.equals(this.email);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.name, this.email);
	}

	/**
	 * @return representation lisible de l'objet
	 */
	public String toString() {
		return this.name;
	}

}
