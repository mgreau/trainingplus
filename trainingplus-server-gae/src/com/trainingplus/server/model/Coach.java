package com.trainingplus.server.model;

import com.googlecode.objectify.annotation.Subclass;


/**
 * Un joueur.
 * 
 * @author Maxime Gréau <dev@mgreau.com>
 *
 */
@Subclass
public class Coach extends Person {
	
	/** Le meilleur pied du joueur */
	private String certificate;

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	@SuppressWarnings("unused")
	private Coach(){
		super();
	}
	
	public Coach(String name, String email) {
		super(name, email);
	}

}

