package com.trainingplus.model.training.exercice;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.trainingplus.model.training.TrainingSession;

/**
 * Un exercice pour une séance d'entrainement bien définie.
 * 
 * <p>Ceci permet de préciser la durée de l'exercice pour cette séance d'entrainement ainsi que 
 * la position de l'exercice dans la séance d'entrainement.</p>
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
public class TrainingSessionExercice {
	
	/** L'exercie à réaliser pour cette session */
	@ManyToOne
	public TrainingExercice exercice;
	
	/** La séance d'entrainement */
	@ManyToOne
	public TrainingSession session;
	
	/** La position de l'exercice par rapport aux autres exercices dans cette séance */
	public Integer pos;
	
	/** La durée de l'exercice en secondes */
	public Integer duration;
	
	/** Commentaires spécifique à cette séance pour cet exercice */
	public String comments;

	public TrainingSessionExercice(TrainingExercice exercice,
			TrainingSession training, Integer position, Integer duration) {
		super();
		this.exercice = exercice;
		this.session = training;
		this.pos = position;
		this.duration = duration;
	}

}
