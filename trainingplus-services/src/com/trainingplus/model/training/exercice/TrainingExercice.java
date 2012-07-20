package com.trainingplus.model.training.exercice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.trainingplus.model.Category;
import com.trainingplus.model.training.TrainingAccessory;

/**
 * Un exercice à effectuer lors d'une séance d'entrainement.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 * 
 */
@Entity
public class TrainingExercice {

	/** Le titre de l'exercice */
	public String title;

	/** Objectif de l'exercice */
	@Lob
	public String objective;

	/** Explication de l'exercice */
	@Lob
	public String content;

	/** Les critères pour rendre cet exercice efficace */
	@Lob
	public String efficiencyCriteria;

	/** La durée recommandée pour cet exercice */
	public Integer duration;

	/** Le thème de l'exercice de l'exercice */
	@ManyToOne
	public TrainingExerciceTheme theme;

	/** Les sessions d'entrainement qui proposent cet exercice */
	@OneToMany(mappedBy = "exercice", cascade = CascadeType.PERSIST)
	public List<TrainingSessionExercice> sessions;

	/** Les accessoires utilisés pour cet exercice */
	@OneToMany(mappedBy = "exercice", cascade = CascadeType.PERSIST)
	public List<TrainingExerciceAccessories> accessories;

	/** Les catégories de joueurs ciblées par cet exercice */
	@ManyToMany
	public List<Category> categories;

	public TrainingExercice(String title, String objective, String content,
			String efficiencyCriteria, Integer duration,
			TrainingExerciceTheme theme) {
		super();
		this.title = title;
		this.objective = objective;
		this.content = content;
		this.efficiencyCriteria = efficiencyCriteria;
		this.duration = duration;
		this.theme = theme;
		this.sessions = new ArrayList<TrainingSessionExercice>();
		this.accessories = new ArrayList<TrainingExerciceAccessories>();
		this.categories = new ArrayList<Category>();
	}

	/**
	 * Ajoute un accessoire, dans une quantité donnée, à un exercice.
	 * 
	 * @param pAccessory
	 *            l'accessoire nécessaire pour l'exercice
	 * @param pQuantity
	 *            le nombre d'éléments (1 par défaut)
	 * @return l'instance de cet exercice
	 */
	public TrainingExercice addAccessory(TrainingAccessory pAccessory,
			Integer pQuantity) {
		if (pQuantity == null)
			pQuantity = 1;
		if (pQuantity != 0) {
			TrainingExerciceAccessories exAcc = new TrainingExerciceAccessories(
					this, pAccessory, pQuantity);
			this.accessories.add(exAcc);
		}

		return this;
	}

}
