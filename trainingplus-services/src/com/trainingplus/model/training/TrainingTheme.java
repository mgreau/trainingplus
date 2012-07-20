package com.trainingplus.model.training;

import javax.persistence.Entity;

/**
 * Le thème général sur lequel l'entrainement va porter.
 * 
 * <p>
 * Par exemple :
 * <ul>
 * <li>le physique</li>
 * <li>le jeu</li>
 * <li>la récupération</li>
 * <li>jeu + endurance puissance</li>
 * </ul>
 * </p>
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
public class TrainingTheme {
	
	/** Le titre du thème */
	public String title;
	
	/** Précision sur le thème  */
	public String content;

	public TrainingTheme(String title) {
		super();
		this.title = title;
	}

}
