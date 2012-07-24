package com.trainingplus.endpoint;

import com.trainingplus.dao.ObjectifyDAO;
import com.trainingplus.model.Club;

import com.google.api.server.spi.config.Api;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "clubendpoint")
public class ClubEndpoint {
	
	private void setUp(){
		new ObjectifyDAO();
	}

  /**
   * This method lists all the entities inserted in datastore.
   * It uses HTTP GET method.
   *
   * @return List of all entities persisted.
   */
  @SuppressWarnings({"cast", "unchecked"})
  public List<Club> listClub() {
    EntityManager mgr = getEntityManager();
    List<Club> result = new ArrayList<Club>();
    try{
      Query query = mgr.createQuery("select from Club");
      for (Object obj : (List<Object>) query.getResultList()) {
        result.add(((Club) obj));
      }
    } finally {
      mgr.close();
    }
    return result;
  }

  /**
   * This method gets the entity having primary key id. It uses HTTP GET method.
   *
   * @param id the primary key of the java bean.
   * @return The entity with primary key id.
   */
  public Club getClub(@Named("id") Long id) {
    EntityManager mgr = getEntityManager();
    Club club  = null;
    try {
      club = mgr.find(Club.class, id);
    } finally {
      mgr.close();
    }
    return club;
  }

  /**
   * This inserts the entity into App Engine datastore.
   * It uses HTTP POST method.
   *
   * @param club the entity to be inserted.
   * @return The inserted entity.
   */
  public Club insertClub(Club club) {
	  setUp();
	  Objectify ofy = ObjectifyService.begin();
	  ofy.put(club);
    return club;
  }

  /**
   * This method is used for updating a entity.
   * It uses HTTP PUT method.
   *
   * @param club the entity to be updated.
   * @return The updated entity.
   */
  public Club updateClub(Club club) {
    EntityManager mgr = getEntityManager();
    try {
      mgr.persist(club);
    } finally {
      mgr.close();
    }
    return club;
  }

  /**
   * This method removes the entity with primary key id.
   * It uses HTTP DELETE method.
   *
   * @param id the primary key of the entity to be deleted.
   * @return The deleted entity.
   */
  public Club removeClub(@Named("id") Long id) {
    EntityManager mgr = getEntityManager();
     Club club  = null;
    try {
      club = mgr.find(Club.class, id);
      mgr.remove(club);
    } finally {
      mgr.close();
    }
    return club;
  }

  private static EntityManager getEntityManager() {
    return EMF.get().createEntityManager();
  }

}
