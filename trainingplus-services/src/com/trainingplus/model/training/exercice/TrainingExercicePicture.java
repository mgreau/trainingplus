package com.trainingplus.model.training.exercice;

import javax.persistence.Entity;


/**
 * Document pour illustrer l'exercice.
 * 
 * <p>Ce document peut être une image, un PDF, une vidéo, un document Word.</p>
 * 
 * <p>La gestion des documents est effectuée via Alfresco.</p>
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
public class TrainingExercicePicture {
	
	/** Universal unique identifier pour communication avec alfresco */
	public String uuid;
	
	public String typeDocument;

}
