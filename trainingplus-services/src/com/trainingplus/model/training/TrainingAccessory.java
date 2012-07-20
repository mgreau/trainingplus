package com.trainingplus.model.training;

import javax.persistence.Entity;


/**
 * Accessoire d'entra√Ænement. 
 * 
 * @author Maxime Gr√©au <dev@mgreau.com>
 *
 */
@Entity
public class TrainingAccessory {
	
	/** Le libell√© de l'accessoire */
	public String title;
	
	/** Image repr√©sentant l'accessoire */
	public String picture;

	public TrainingAccessory(String title) {
		super();
		this.title = title;
	}

}
