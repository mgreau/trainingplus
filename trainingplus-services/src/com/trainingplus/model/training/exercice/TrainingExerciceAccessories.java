package com.trainingplus.model.training.exercice;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.trainingplus.model.training.TrainingAccessory;

/**
 * Représente l'utilisation d'un accessoire pour un exercice.
 * 
 * <p>Ceci permet de préciser le nombre d'éléments à utiliser pour l'exercice.</p>
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
public class TrainingExerciceAccessories {
	
	/** L'exercie à réaliser pour cette session */
	@ManyToOne
	public TrainingExercice exercice;
	
	/** La séance d'entrainement */
	@ManyToOne
	public TrainingAccessory accessory;
	
	public Integer quantity;
	
	public TrainingExerciceAccessories(TrainingExercice exercice,
			TrainingAccessory accessory, Integer quantity) {
		super();
		this.exercice = exercice;
		this.accessory = accessory;
		this.quantity = quantity;
	}

}
