package com.trainingplus.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;


/**
 * Une catégorie de joueur de sport.
 * 
 * <p>
 * Par exemple : Séniors, Jeunes, U15, U17, Vétérans, Poussins
 * </p>
 * 
 * @author Maxime Gr�au <dev@mgreau.com>
 * 
 */
@Entity
public class Category {

	/** Libellé de la catégorie */
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
		
		return null;
	}

	/**
	 * @return representation lisible de l'objet
	 */
	public String toString() {
		return this.title;
	}

}
