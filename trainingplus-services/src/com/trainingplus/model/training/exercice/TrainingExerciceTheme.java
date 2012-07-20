package com.trainingplus.model.training.exercice;

import javax.persistence.Entity;

/**
 * Le thème de l'exercice.
 * Les exercices peuvent être classés par thème, par ex :
 * <ul>
 * <li>Echauffement</li>
 * <li>Physique</li>
 * <li>Tactique</li>
 * <li>Technique</li>
 * <li>Match</li>
 * </ul>
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
public class TrainingExerciceTheme {
	
	/** Le titre de la catégorie */
	public String title;
	
	/** Précision sur la catégorie  */
	public String content;
	
	public TrainingExerciceTheme(String title) {
		super();
		this.title = title;
	}


}
