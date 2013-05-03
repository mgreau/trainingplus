package com.trainingplus.server.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.appengine.labs.repackaged.com.google.common.base.Objects;


/**
 * Une saison sportive.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Entity
public class Season {
	
	@Id
	Long id;
	
	public Long getId() {
		return id;
	}

	/** Date de début de la saison */
	private Date startDate;
	
	/** Date de fin de la saison */
	private Date endDate;

	public Season(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * for objectify
	 */
	@SuppressWarnings("unused")
	private Season() {
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Season) {
			Season p = (Season) obj;
			return this.startDate != null && p.startDate != null
					&& p.startDate.equals(this.startDate) && this.endDate != null
					&& p.endDate != null && p.endDate.equals(this.endDate);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.startDate, this.endDate);
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
