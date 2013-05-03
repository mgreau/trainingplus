package com.trainingplus.server.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import com.google.appengine.labs.repackaged.com.google.common.base.Objects;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Indexed;
import com.googlecode.objectify.annotation.Unindexed;

/**
 * Entité principale de l'app.
 * 
 * @author mgreau
 * 
 */
@Entity
public class Club {

	@Id Long id;

	/** Nom du club */
	@Indexed
	private String name;
	
	/** Couleur principale du club */
	@Unindexed
	private String color;
	
	/** Les saisons pour lesquelles le club est inscrit */
	@Indexed
	List<Key<SeasonClub>> seasons = new ArrayList<Key<SeasonClub>>();

	public List<Key<SeasonClub>> getSeasons() {
		return seasons;
	}
	
	/**
	 * for objectify
	 */
	@SuppressWarnings("unused")
	private Club() {
	}
	
	public Club(String name) {
		this.name = name;
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getId() {
		return id;
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
