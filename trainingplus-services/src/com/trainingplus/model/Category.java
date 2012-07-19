package com.trainingplus.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * Une catégorie de joueur de sport.
 * 
 * <p>
 * Par exemple : Séniors, Jeunes, U15, U17, Vétérans, Poussins
 * </p>
 * 
 * @author Maxime Gréau <maxime.greau@fiaveo.fr>
 * 
 */
@Entity
public class Category extends Model {

	/** Libellé de la catégorie */
	@Required
	@Column(nullable = false)
	public String title;

	@ManyToMany
	public List<Category> dependOn = new LinkedList<Category>();

	@ManyToMany(mappedBy = "dependOn")
	public List<Category> dependants = new LinkedList<Category>();

	public Category(String title) {
		super();
		this.title = title;
	}

	/**
	 * overrides Model delete method
	 */
	public Category delete() {
		// As dependOn is the owner side
		for (Category cat : dependants) {
			cat.dependOn.remove(this);
			cat.save();
		}

		return super.delete();
	}

	/**
	 * @return representation lisible de l'objet
	 */
	public String toString() {
		return this.title;
	}

}
