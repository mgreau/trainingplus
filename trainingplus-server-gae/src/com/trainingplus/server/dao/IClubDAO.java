package com.trainingplus.server.dao;

import com.trainingplus.server.model.Club;
import com.trainingplus.server.model.Season;

/**
 *	Declare additional Essay-specific methods that aren't covered in the IGenericDAO<T> interface.
 */
public interface IClubDAO extends IGenericDAO<Club> {

	/**
	 * Inscription du club pour une saison
	 * @param club
	 * @param season
	 * @throws Exception si le club est déjà inscrit pour cette saison
	 */
	public void subscribeClubToASeason(Club club, Season season) throws Exception;

}