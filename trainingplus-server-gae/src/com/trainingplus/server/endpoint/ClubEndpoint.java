package com.trainingplus.server.endpoint;

import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;
import com.trainingplus.server.dao.IClubDAO;
import com.trainingplus.server.dao.TplusDAOFactory;
import com.trainingplus.server.model.Club;

@Api(name = "trainingplus")
public class ClubEndpoint {
	
	IClubDAO dao = TplusDAOFactory.getClubDAO();

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method.
	 * 
	 * @return List of all entities persisted.
	 */
	public List<Club> listClub() {
		return dao.listAll();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 * 
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 * @throws EntityNotFoundException 
	 */
	public Club getClub(@Named("id") Long id) throws EntityNotFoundException {
		return dao.get(id);
	}

	/**
	 * This inserts the entity into App Engine datastore. It uses HTTP POST
	 * method.
	 * 
	 * @param club
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	public Club insertClub(Club club) {
		dao.put(club);
		return club;
	}

	/**
	 * This method is used for updating a entity. It uses HTTP PUT method.
	 * 
	 * @param club
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	public Club updateClub(Club club) {
		dao.put(club);
		return club;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 * 
	 * @param id
	 *            the primary key of the entity to be deleted.
	 * @return The deleted entity.
	 * @throws EntityNotFoundException 
	 */
	public Club removeClub(@Named("id") Long id) throws EntityNotFoundException {
		Club c = dao.get(id);
		dao.deleteKey(new Key<Club>(Club.class, id));
		return c;
	}


}
