package com.trainingplus.model.training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.trainingplus.model.Coach;
import com.trainingplus.model.training.exercice.TrainingExercice;
import com.trainingplus.model.training.exercice.TrainingSessionExercice;

/**
 * Une séance d'entrainement.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 * 
 */
@Entity
public class TrainingSession {

	/** Date et Heure de la séance d'entrainement */
	public Date date;

	/** Liste des coachs qui font l'entrainement */
	@ManyToMany(cascade = CascadeType.PERSIST)
	public List<Coach> coachs;

	/** Liste des exercices qui vont être réalisés pendant la séance */
	@OneToMany(mappedBy = "session", cascade = CascadeType.REFRESH)
	public List<TrainingSessionExercice> exercices;
	
	/** Liste des joueurs qui doivent participer à la séance */
	@OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
	public List<TrainingAttendance> players;

	/** Le titre de l'entrainement */
	public String title;

	/** Le résumé de la séance */
	public String content;

	public TrainingSession(Date date, String title, String content) {
		super();
		this.date = date;
		this.title = title;
		this.content = content;
		this.coachs = new ArrayList<Coach>();
		this.exercices = new ArrayList<TrainingSessionExercice>();
		this.players = new ArrayList<TrainingAttendance>();
	}
	
	/**
	 * Ajoute un accessoire, dans une quantité donnée, à un exercice.
	 * 
	 * @param pAccessory
	 *            l'accessoire nécessaire pour l'exercice
	 * @param pDuration
	 *            le nombre d'éléments (1 par défaut)
	 * @return l'instance de cet exercice
	 */
	public TrainingSession addExercice(TrainingExercice pExercice,
			Integer pDuration) {
		if (pDuration == null)
			pDuration = 1;
		if (pDuration != 0) {
			TrainingSessionExercice exe = new TrainingSessionExercice(pExercice,
					this, 0, pDuration);
			this.exercices.add(exe);
		}
		
		return this;
	}



}
