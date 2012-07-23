package com.trainingplus.model;

import javax.persistence.Id;

import com.google.appengine.labs.repackaged.com.google.common.base.Objects;

/**
 * Entité principale de l'app.
 * 
 * @author mgreau
 * 
 */
public class Club {

	@Id
	Long id;

	/** Nom du club */
	String name;

	public Club() {

	}

	public Club(String name) {
		super();
		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Club) {
			Club c = (Club) obj;
			return this.name != null && c.name != null
					&& c.name.equals(this.name);
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return Objects.hashCode(this.name);
	}

}
