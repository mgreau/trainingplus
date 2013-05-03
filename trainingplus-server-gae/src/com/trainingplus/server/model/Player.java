package com.trainingplus.server.model;

import com.googlecode.objectify.annotation.Subclass;


/**
 * Un joueur.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Subclass
public class Player extends Person {
	
	public String getBestFoot() {
		return bestFoot;
	}

	public void setBestFoot(String bestFoot) {
		this.bestFoot = bestFoot;
	}

	/** Le meilleur pied du joueur */
	private String bestFoot;
	
	@SuppressWarnings("unused")
	private Player(){
		super();
	}
	

	public Player(String name, String email) {
		super(name, email);
	}

}

