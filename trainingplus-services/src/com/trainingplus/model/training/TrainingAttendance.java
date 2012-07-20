package com.trainingplus.model.training;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.trainingplus.model.Player;

/**
 * La participation d'un joueur à une séance d'entrainement.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
public class TrainingAttendance {
	
	/** Le joueur qui doit participer à la séance d'entrainement */
	@ManyToOne
	public Player player;
	
	/** La séance d'entraînement */
	@ManyToOne
	public TrainingSession session;
	
	/** Est-ce que le joueur est présent à la séance */
	public boolean isPresent;
	
	/** Est-ce que le joueur a prévénu de son absence */
	public boolean isExcused;
	
	/** Est-ce que le joueur est dispensé de séance */
	public boolean isDispensed;
	
	/** Explication sur l'absence du joueur */
	public String details;

}
