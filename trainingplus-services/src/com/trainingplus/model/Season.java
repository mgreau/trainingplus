package com.trainingplus.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;


/**
 * Une saison sportive.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
public class Season {
	
	/** Date de début de la saison */
	@Column(nullable = false)
	public Date startDate;
	
	/** Date de fin de la saison */
	@Column(nullable = false)
	public Date endDate;

	public Season(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * @return representation lisible de l'objet
	 */
	public String toString() {
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		Integer startYear = c.get(Calendar.YEAR);
		c.setTime(endDate);
		return startYear + " - " + c.get(Calendar.YEAR);
	}

}
